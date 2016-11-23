package chap11.threads.immutability;

/**
 * Created by Stas on 15/01/2015.
 */
public class ImmutableDemo {

    public static void main(String[] args) throws InterruptedException {

        final Calculator calculator = new Calculator();


        calculator.setValue(new ImmutableValue(0));
        System.out.println("Value address in main: " + calculator.getValue());
        new Thread() {
            public void run() {

                calculator.add(20);
                System.out.println("in thread #1, value = " + calculator.getValue().getValue());
            }
        }.start();

        new Thread() {
            public void run() {
                calculator.add(100);
                System.out.println("in thread #2, value = " + calculator.getValue().getValue());
            }
        }.start();


        Thread.sleep(100);
        System.out.println("in main, value = " + calculator.getValue().getValue());
        System.out.println("Value address in main: " + calculator.getValue());
    }
}
