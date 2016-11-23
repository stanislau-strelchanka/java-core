package chap11.threads;

/**
 * Created by Stas on 13/01/2015.
 */
public class YieldDemo {

    public static void main(String[] args) {

        new Thread(){
            public void run(){
                System.out.println("старт потока 1");
                Thread.yield();
                System.out.println("завершение 1");
            }
        }.start();

        new Thread(){
            public void run(){
                System.out.println("старт потока 2");
                System.out.println("завершение 2");
            }
        }.start();
    }
}
