package chap11.threads.exceptions;

/**
 * Created by Stas on 13/01/2015.
 */
public class ExceptMain extends Thread {

    public void run(){

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end of SimpleThread");
    }
}
