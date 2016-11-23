package chap9.streams.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Stas on 17/01/2015.
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.println("Enter your name");
        String name=br.readLine();
        System.out.println("Welcome "+name);
    }
}
