package chap9.streams.io;

import helpers.Helper;

import java.io.*;

/**
 * Created by Stas on 13/01/2015.
 */
public class ByteArrayOutputStreamDemo {

    public static void main(String[] args) throws IOException {

        FileOutputStream f1 = new FileOutputStream(Helper.PATH9 + "f1.txt");
        FileOutputStream f2 = new FileOutputStream(Helper.PATH9 + "f2.txt");

        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ba.write(new byte[]{33,53,53,64,43});
        ba.writeTo(f1);
        ba.writeTo(f2);

    }
}
