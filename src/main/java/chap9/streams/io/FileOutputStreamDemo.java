package chap9.streams.io;

import helpers.Helper;

import java.io.*;

/**
 * Created by Stas on 09/01/2015.
 */
public class FileOutputStreamDemo {


    public static void main(String[] args) {

        String pArray[] = {"2013", "Java SE 8"};
        File fByte = new File (Helper.PATH9 + "byte.data");
        File fSymb = new File(Helper.PATH9 + "symbol.txt");

        FileOutputStream fos = null;
        FileWriter fw = null;
        try{
            fos = new FileOutputStream(fByte);
            fw = new FileWriter(fSymb);
            for (String s : pArray) {
                fos.write(s.getBytes());
                fw.write(s);
            }
        }
        catch (IOException e){
            //
        }
        finally {
            {
                try{
                    if(fos != null)
                        fos.close();
                    if(fw != null)
                        fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
