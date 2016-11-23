package chap11.threads.threadsafestructures;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    try {
                        queue.put("Java" + i);
                        System.out.println("Element " + i + " added");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                try {
                    while(!queue.isEmpty()){
                        Thread.sleep(1000);
                        System.out.println("Element " + queue.take() + " took");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
