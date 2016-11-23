package chap9.streams.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Stas on 03/03/2015.
 */
public class ServerSocketChannelDemo {

    private static void blockingEx() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            //do something with socketChannel...
        }
    }

    private static void nonBlockingEx() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            if(socketChannel != null){
                //do something with socketChannel...
            }
        }
    }
}
