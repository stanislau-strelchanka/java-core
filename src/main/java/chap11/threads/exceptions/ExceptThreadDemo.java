package chap11.threads.exceptions;

/**
 * Created by Stas on 13/01/2015.
 */
public class ExceptThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        new ExceptThread().start();
        Thread.sleep(1000);
        System.out.println("end of main");
    }
}
