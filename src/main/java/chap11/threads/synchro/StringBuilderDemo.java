package chap11.threads.synchro;

/**
 * Created by Stas on 13/01/2015.
 */
public class StringBuilderDemo {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        final StringBuilder s = new StringBuilder();
        new Thread(){
            public void run(){
                synchronized (s) {
                    do{
                        s.append("A");
                        System.out.println(s);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.err.print(e);
                        }
                    } while (StringBuilderDemo.counter++ < 2);
                } // к онец synchronized

            }
        }.start();
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (StringBuilderDemo.counter++ < 6) {
                        s.append("B");
                        System.out.println(s);
                    }
                } // к онец synchronized
            }
        }.start();

    }
}
