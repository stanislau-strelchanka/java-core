package chap9.streams.serial;

import helpers.Helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Stas on 09/01/2015.
 */
public class SerializeRunner {

    public static void main(String[] args) throws FileNotFoundException {
        Student ob = new Student("MMF", "Goncharenko", 1, "G017s9");
        System.out.println(ob);
        String file = Helper.PATH9 + "demo.data";
        Serializator sz = new Serializator();
        boolean b = sz.serialization(ob,file);
        Student.faculty = "GEO";
        Student res = null;
        res = sz.deserialization(file);
        System.out.println(res);

        new PrintWriter(new File(""));
    }
}
