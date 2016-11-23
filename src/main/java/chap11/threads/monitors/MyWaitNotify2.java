package chap11.threads.monitors;

/**
 * Created by Stas on 15/01/2015.
 */

//no missed signals
public class MyWaitNotify2 {

    boolean wasSignalled = false;

    public void doWait(){

        synchronized (this){

            if(!wasSignalled){
                try
                {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify(){

        wasSignalled = true;
        this.notify();
    }
}
