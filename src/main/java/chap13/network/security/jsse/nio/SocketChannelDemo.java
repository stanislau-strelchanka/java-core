package chap13.network.security.jsse.nio;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by Stas on 02/03/2015.
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {

        String hostname = InetAddress.getLocalHost().getHostAddress();
        int port = 3366;

        SSLEngine engine = InitSSLContext.go(hostname, port);
        connect(hostname, port, engine);


    }

    private static void connect(String hostname, int port, SSLEngine engine) throws IOException {

        // Create a non-blocking socket channel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(hostname, port));

        while (!socketChannel.finishConnect()) {
            // do something until connect completed
        }
        // Create byte buffers to use for holding application and encoded data
        SSLSession session = engine.getSession();
        ByteBuffer myAppData = ByteBuffer.allocate(session.getApplicationBufferSize());
        ByteBuffer myNetData = ByteBuffer.allocate(session.getPacketBufferSize());
        ByteBuffer peerAppData = ByteBuffer.allocate(session.getApplicationBufferSize());
        ByteBuffer peerNetData = ByteBuffer.allocate(session.getPacketBufferSize());

        // Do initial handshake
        doHandshake(socketChannel, engine, myNetData, peerNetData);
        
        myAppData.put("Hello".getBytes());
        myAppData.flip();
        while (myAppData.hasRemaining()){
            SSLEngineResult result = engine.wrap(myAppData, myNetData);
            if(result.getStatus() == SSLEngineResult.Status.OK){
                myAppData.compact();
                int num = socketChannel.write(myNetData);
                if (num == -1) {
                    // handle closed channel
                } else if (num == 0) {
                    // no bytes written; try again later
                }else{
                    result = engine.unwrap(peerNetData, peerAppData);
                    if (result.getStatus() == SSLEngineResult.Status.OK) {
                        peerNetData.compact();

                        if (peerAppData.hasRemaining()) {
                            // Use peerAppData
                        }
                    }
                }
            } else if(result.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW){

                if(session.getPacketBufferSize() > peerNetData.capacity()){
                    //enlarge capacity
                } else {
                    //compact or clear netData
                }

            } else if(result.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW){
                if(session.getApplicationBufferSize() > myAppData.capacity()){
                    if(session.getApplicationBufferSize() > peerAppData.capacity()){
                        //enlarge capacity
                    }else{
                        //comcact or clear appData
                    }
                }
            }
        }
    }

    private static void doHandshake(SocketChannel socketChannel, SSLEngine engine,
                                    ByteBuffer myNetData, ByteBuffer peerNetData) {

        try {
            if (socketChannel.read(peerNetData) < 0) {
                // Handle closed channel
        // Create byte buffers to use for holding application data
        int appBufferSize = engine.getSession().getApplicationBufferSize();
        ByteBuffer myAppData = ByteBuffer.allocate(appBufferSize);
        ByteBuffer peerAppData = ByteBuffer.allocate(appBufferSize);

        // Begin handshake
        engine.beginHandshake();
        SSLEngineResult.HandshakeStatus hs = engine.getHandshakeStatus();

        // Process handshaking message

        while (hs != SSLEngineResult.HandshakeStatus.FINISHED &&
                hs != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {

            switch (hs) {

                case NEED_UNWRAP:
                    // Receive handshaking data from peer

                    // Process incoming handshaking data
                    peerNetData.flip();
                    SSLEngineResult res = engine.unwrap(peerNetData, peerAppData);
                    peerNetData.compact();
                    hs = res.getHandshakeStatus();

                    // Check status
                    switch (res.getStatus()) {
                        case OK :
                            // Handle OK status
                            break;

                        // Handle other status: BUFFER_UNDERFLOW, BUFFER_OVERFLOW, CLOSED

                    }
                    break;

                case NEED_WRAP :
                    // Empty the local network packet buffer.
                    myNetData.clear();

                    // Generate handshaking data
                    res = engine.wrap(myAppData, myNetData);
                    hs = res.getHandshakeStatus();

                    // Check status
                    switch (res.getStatus()) {
                        case OK :
                            myNetData.flip();

                            // Send the handshaking data to peer
                            while (myNetData.hasRemaining()) {
                                if (socketChannel.write(myNetData) < 0) {
                                    // Handle closed channel
                                }
                            }
                            break;

                        // Handle other status:  BUFFER_OVERFLOW, BUFFER_UNDERFLOW, CLOSED

                    }
                    break;

                case NEED_TASK :
                    // Handle blocking tasks
                    break;

                // Handle other status:  // FINISHED or NOT_HANDSHAKING
            }
        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Processes after handshaking
    }

    public static void close(SSLEngine engine, ByteBuffer myNetData, SocketChannel socketChannel){

        try {
            // Indicate that application is done with engine
            engine.closeOutbound();
            ByteBuffer empty = ByteBuffer.allocate(myNetData.capacity());
            while (!engine.isOutboundDone()) {
                // Get close message
                SSLEngineResult res = engine.wrap(empty, myNetData);

                // Check res statuses

                // Send close message to peer
                while (myNetData.hasRemaining()) {
                    int num = socketChannel.write(myNetData);
                    if (num == -1) {
                        // handle closed channel
                    } else if (num == 0) {
                        // no bytes written; try again later
                    }
                    myNetData.compact();
                }
            }

            // Close transport
            socketChannel.close();
        }catch (IOException e){}
    }
}
