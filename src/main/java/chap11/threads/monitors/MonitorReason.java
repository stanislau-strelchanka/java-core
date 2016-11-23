package chap11.threads.monitors;

/**
 * Thread can execute only one method at a time
 * as there is one lock object
 */
public class MonitorReason {

    /**
     * Locks instance object
     */
    public synchronized void log1(String msg1, String msg2) {
        System.out.println(msg1);
        System.out.println(msg2);
    }


    public void log2(String msg1, String msg2) {
        synchronized (this) {
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

}
