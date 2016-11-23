package chap9.streams.nio;

import helpers.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Stas on 03/03/2015.
 */
public class SelectorsDemo {

    public static void main(String[] args) throws IOException {

        //FileChannel channel = new FileInputStream(Helper.PATH9 + "byte_buffer_tempout.txt").getChannel();
        //fileChanels cannot be nonblocking
        SocketChannel channel = new SocketChannel(SelectorProvider.provider()) {
            @Override
            protected void implCloseSelectableChannel() throws IOException {

            }

            @Override
            protected void implConfigureBlocking(boolean block) throws IOException {

            }

            @Override
            public SocketChannel bind(SocketAddress local) throws IOException {
                return null;
            }

            @Override
            public SocketAddress getLocalAddress() throws IOException {
                return null;
            }

            @Override
            public <T> SocketChannel setOption(SocketOption<T> name, T value) throws IOException {
                return null;
            }

            @Override
            public <T> T getOption(SocketOption<T> name) throws IOException {
                return null;
            }

            @Override
            public Set<SocketOption<?>> supportedOptions() {
                return null;
            }

            @Override
            public SocketChannel shutdownInput() throws IOException {
                return null;
            }

            @Override
            public SocketChannel shutdownOutput() throws IOException {
                return null;
            }

            @Override
            public Socket socket() {
                return null;
            }

            @Override
            public boolean isConnected() {
                return false;
            }

            @Override
            public boolean isConnectionPending() {
                return false;
            }

            @Override
            public boolean connect(SocketAddress remote) throws IOException {
                return false;
            }

            @Override
            public boolean finishConnect() throws IOException {
                return false;
            }

            @Override
            public SocketAddress getRemoteAddress() throws IOException {
                return null;
            }

            @Override
            public int read(ByteBuffer dst) throws IOException {
                return 0;
            }

            @Override
            public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public int write(ByteBuffer src) throws IOException {
                return 0;
            }

            @Override
            public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
                return 0;
            }
        };
        Selector selector = Selector.open();

        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);


        while(true) {

            int readyChannels = selector.select();

            if(readyChannels == 0) continue;


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                key = keyIterator.next();

                if(key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    SelectableChannel channel1 = key.channel();

                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.

                } else if (key.isReadable()) {
                    // a channel is ready for reading

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }

                keyIterator.remove();
            }
        }
    }
}
