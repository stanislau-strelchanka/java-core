package chap9.streams.io;

import helpers.Helper;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Stas on 17/01/2015.
 */
public class CharArrayWriterDemo {

    public static void main(String[] args) throws IOException {

        CharArrayWriter cw = new CharArrayWriter();
        cw.write("writing with chararraywriter");

        FileWriter a = new FileWriter(Helper.PATH9 + "a.txt");
        FileWriter b = new FileWriter(Helper.PATH9 +new File("b.txt"));
        FileWriter c = new FileWriter(Helper.PATH9 +new File("c.txt"));

        cw.writeTo(a);cw.writeTo(b);cw.writeTo(c);
        a.close();b.close();c.close();

    }
}
