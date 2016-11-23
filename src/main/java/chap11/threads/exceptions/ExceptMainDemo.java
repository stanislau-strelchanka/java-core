package chap11.threads.exceptions;

/**
 * Created by Stas on 13/01/2015.
 */
public class ExceptMainDemo {

    public static void main(String[] args) {

        new ExceptMain().start();

        if(true)
            throw new RuntimeException();
        System.out.println("end of main");//thread will be working
    }

}
