package chap11.threads.exceptions;

/**
 * Created by Stas on 13/01/2015.
 */
public class ExceptThread extends Thread {

    public void run(){

        if(true){

        throw new RuntimeException();
        }
        System.out.println("end of Except");
    }
}
