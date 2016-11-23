package chap11.threads;

/**
 * Created by Stas on 12/01/2015.
 */



public class WalkTalkDemo {

    static public class WalkRunnable implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {

                System.out.println("Walking");
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static public class TalkThread extends Thread {

        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {

                System.out.println("Talking");
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TalkThread talkThread = new TalkThread();
        Thread thread = new Thread(new WalkRunnable());
        talkThread.start();
        thread.start();
        //talkThread.run();
        //thread.run(); thread will not be executed, just method
    }
}
