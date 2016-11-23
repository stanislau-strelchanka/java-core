package chap11.threads.synchro;

/**
 * Created by Stas on 09/03/2015.
 */

class ClassLock {

    public String method(){

        return "aaaaaaa";
    }
}

public class ClassLockDemo {

    public static void main(String[] args) throws InterruptedException {

        ClassLock classLock = new ClassLock();

        new Thread(){
            @Override
            public void run() {
                synchronized (ClassLock.class){

                    System.out.println("First thread with lock start");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("First thread with lock end");
                }
            }
        }.start();
        Thread.sleep(100);

        //synchronized (ClassLock.class) {
        // uncomment, so it will wait for first thread
            System.out.println(classLock.method());
        //}
    }
}
