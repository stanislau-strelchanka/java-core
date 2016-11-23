package chap9.streams.io;

import helpers.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Stas on 13/01/2015.
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream fis1 = new FileInputStream(Helper.PATH9 + "res.txt");
        FileInputStream fis2 = new FileInputStream(Helper.PATH9 + "f1.txt");
        FileInputStream fis3 = new FileInputStream(Helper.PATH9 + "f2.txt");

        Vector vector = new Vector();
        vector.add(fis1);
        vector.add(fis2);
        vector.add(fis3);

        Enumeration elements = vector.elements();
        new SequenceInputStream(fis1,fis2); // 2 args ok
        SequenceInputStream sis = new SequenceInputStream(elements);// or enumeration
        int i = 0;
        while((i = sis.read()) != -1){
            System.out.println((char)i);
        }
    }
}
