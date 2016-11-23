package chap9.streams.io;

import helpers.Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Stas on 09/01/2015.
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {

        BufferedReader br = null;
        try{


            br = new BufferedReader(new FileReader(Helper.PATH9 + "res.txt"));
            String tmp = "";
            while ((tmp = br.readLine()) != null){
                String[] s = tmp.split(" ");
                for (String s1 : s) {
                    System.out.println(s1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(br != null){
                try{
                    br.close();
                } catch (IOException e){

                }
            }
        }
    }
}
