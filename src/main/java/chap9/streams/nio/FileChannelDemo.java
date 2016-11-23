package chap9.streams.nio;

import helpers.Helper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Stas on 03/03/2015.
 */
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile     = new RandomAccessFile(Helper.PATH9 + "byte_buffer_tempout.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        readFromChannel(inChannel);
        writeToChannel();
    }

    private static void writeToChannel() throws IOException {

        String newData = "New String to write to file..." + System.currentTimeMillis();
        FileChannel channel = new FileOutputStream(Helper.PATH9 + "byte_buffer_tempout.txt").getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            channel.write(buf);
        }
    }

    private static void readFromChannel(FileChannel inChannel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
    }


}
