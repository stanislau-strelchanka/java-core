package chap11.threads.monitors;

import java.util.Scanner;

/**
 * Created by Stas on 14/01/2015.
 */
public class PaymentDemo {

    static class Payment {

        private int amount;
        private boolean close;

        public int getAmount() {
            return amount;
        }

        public boolean isClose() {
            return close;
        }

        public synchronized void doPayment() {

            try {
                System.out.println("Start payment: ");
                while (amount <= 0) {
                    System.out.println("I'm calling wait");
                    this.wait();
                }
                System.out.println("I left wait");
                close = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Payment is closed : " + close + " " + amount);
        }

        public void initAmount() {
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextInt();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Payment payment = new Payment();
        new Thread() {

            public void run() {
                payment.doPayment();
            }
        }.start();

        Thread.sleep(200);

        synchronized (payment) {
            payment.notify();
            //notify position doesn't matters
            //lock will be acquired after this block finishes
            Thread.sleep(5000);//no effect
            System.out.println("Init amount: ");
            payment.initAmount();
        }
        System.out.println("between two synchronized blocks");
        synchronized (payment) {
            System.out.println("inside second synchro block");
            payment.wait(1000);
            System.out.println("ok");
        }

    }
}
