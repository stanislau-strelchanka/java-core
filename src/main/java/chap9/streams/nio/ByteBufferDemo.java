package chap9.streams.nio;

import helpers.Helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Stas on 02/03/2015.
 */
public class ByteBufferDemo {

    private static void showStats( String where, FileChannel fc, Buffer b ) throws IOException
    {
        System.out.println(where +
                " channelPosition: " +
                fc.position() +
                " bufferPosition: " +
                b.position() +
                " limit: " +
                b.limit() +
                " remaining: " +
                b.remaining() +
                " capacity: " +
                b.capacity());
    }


    private static void writeRawBytes() throws IOException
    {
        final FileOutputStream fos = new FileOutputStream(Helper.PATH9 + "byte_buffer_tempout.txt");
        // allocate a channel to write that file
        FileChannel fc = fos.getChannel();
        // allocate a buffer, as big a chunk as we are willing to handle at a pop.
        //  Unlike the buffer on a stream, item is up to you not to overflow the buffer.
        ByteBuffer buffer = ByteBuffer.allocate( 1024 * 15 );
        showStats( "newly allocated write", fc, buffer );
        // write 10 buffers each partly full.
        for ( int i = 0; i < 10; i++ )
        {
            // prepare buffer to fill with data.
            buffer.clear();
            showStats( "after clear", fc, buffer );
            // Put some data in the buffer, up to 15K worth.
            for ( int j = 0; j < 100; j++ )
            {
                // Put bytes, not char[] or String.
                buffer.put( "hello".getBytes( "8859_1"/* encoding */ ) );
                showStats( "after put", fc, buffer );
            }
            // flip from filling to emptying to prepare buffer for write
            showStats( "before flip", fc, buffer );
            buffer.flip();
            showStats( "after flip", fc, buffer );
            // write a chunk of raw bytes, up to 15K bytes long
            fc.write( buffer );
            showStats( "after write", fc, buffer );
        }
        fc.close();
    }

    private static void readRawBytes() throws IOException
    {
        final FileInputStream fis = new FileInputStream(Helper.PATH9 + "byte_buffer_tempout.txt");
        // allocate a channel to read that file
        FileChannel fc = fis.getChannel();
        // allocate a buffer, as big a chunk as we are willing to handle at a pop.
        ByteBuffer buffer = ByteBuffer.allocate( 1024 * 15 );
        showStats( "newly allocated read", fc, buffer );
        // read a chunk of raw bytes, up to 15K bytes long
        // -1 means eof.
        int bytesRead = fc.read( buffer );
        showStats( "after first read", fc, buffer );
        // flip from filling to emptying
        showStats( "before flip", fc, buffer );
        buffer.flip();
        showStats( "after flip", fc, buffer );
        byte[] receive = new byte[ 1024 ];
        buffer.get( receive );
        showStats( "after first get", fc, buffer );
        buffer.get( receive );
        showStats( "after second get", fc, buffer );
        // empty buffer to fill with more data.
        buffer.clear();
        showStats( "after clear", fc, buffer );
        bytesRead = fc.read( buffer );
        showStats( "after second read", fc, buffer );
        // flip from filling to emptying
        showStats( "before flip", fc, buffer );
        buffer.flip();
        showStats( "after flip", fc, buffer );
        fc.close();
    }


    public static void main( String[] args ) throws IOException
    {
        writeRawBytes();
        System.out.println("Reading...");
        readRawBytes();
    }
}

