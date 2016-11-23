package chap11.threads.monitors;

/**
 * Created by Stas on 15/01/2015.
 */

//no missed signals and spurious wakeups
public class MyWaitNotify3  {

    boolean wasSignalled = false;

    public void doWait(){

        synchronized (this){

            while(!wasSignalled){
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
