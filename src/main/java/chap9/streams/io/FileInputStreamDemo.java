package chap9.streams.io;

import helpers.Helper;

import java.io.*;

/**
 * Created by Stas on 09/01/2015.
 */
public class FileInputStreamDemo {


    public static void main(String[] args) {

        String file = Helper.PATH9 + "file.txt";
        File f = new File(file);

        int b = 0, count = 0;
        FileReader is = null;
        FileInputStream fis = null;

        try{
            is = new FileReader(f);
            fis = new FileInputStream(new File(Helper.PATH9 + "byte.data"));
            while((b = is.read()) != -1){
                System.out.println((char)b);
                count++;
            }
            while((b = fis.read()) != -1){

                System.out.println(new StringBuilder().append((char)b));
            }

            is = new FileReader(new File(Helper.PATH9 + "symbol.txt"));
            while ((b = is.read()) != -1){
                System.out.println((char) b);
            }
            System.out.println("\n чисол байт = " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Autoclosable
/*        finally {
            try{
                if(is != null){
                    is.close();
                }
            }catch (IOException e){

            }
        }*/

    }
}
