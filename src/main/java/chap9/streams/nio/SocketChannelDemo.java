package chap9.streams.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Stas on 03/03/2015.
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        readFromSocketChannel(socketChannel);

        writeToBuffer(socketChannel);
    }

    private static void writeToBuffer(SocketChannel socketChannel) throws IOException {
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            socketChannel.write(buf);
        }
    }

    private static void readFromSocketChannel(SocketChannel socketChannel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);
    }

    private static void nonBlokingEx(SocketChannel socketChannel) throws IOException {

        //open, read, write are asynchronous
        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }
    }
}
