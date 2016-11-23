package chap11.threads.atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDemo {

    static public class Broker extends Thread {

        private Market market;
        private static final int PAUSE = 500;

        public Broker(Market market){
            this.market = market;
        }

        @Override
        public void run(){

            try{
                while (true){
                    System.out.println("Current index: " + market.getIndex());
                    Thread.sleep(PAUSE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static public class Market extends Thread {

        private AtomicLong index;
        public Market(AtomicLong index){

            this.index = index;
        }

        public AtomicLong getIndex(){
            return index;
        }

        @Override
        public void run(){

            Random random = new Random();
            try{
                while(true){
                    index.addAndGet(random.nextInt(10));
                    Thread.sleep(random.nextInt(500));
                    index.addAndGet(-1 * random.nextInt(10));
                    Thread.sleep(random.nextInt(500));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static final int NUMBER_BROKERS = 30;

    public static void main(String[] args) {

        Market market = new Market(new AtomicLong(100));
        market.start();
        for(int i = 0; i < AtomicDemo.NUMBER_BROKERS; i++){
            new Broker(market).start();
        }
    }
}
