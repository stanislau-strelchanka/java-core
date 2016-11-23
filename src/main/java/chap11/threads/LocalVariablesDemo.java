package chap11.threads;

/**
 * Created by Stas on 15/01/2015.
 */
public class LocalVariablesDemo {

    public class MyRunnable implements Runnable{

        public void run(){
            methodOne();
        }

        private void methodOne() {

            int localVariable1 = 45; // stored on the stack thread
            LocalVariablesDemo localVariable2 = LocalVariablesDemo.sharedInstance;// shared among both threads
                                                                                  //but reference  on the stack thread
            methodTwo();

        }

        public void methodTwo(){

            Integer localVariable3 = new Integer(99);//ref stored on the stack thread
                                                    // but object on the heap
        }
    }

    public static final LocalVariablesDemo sharedInstance = new LocalVariablesDemo();

    public Integer object2 = new Integer(22);//shared among both threads
    public Integer object4 = new Integer(44);//shared among both threads

    public long member1 = 12345;//shared among both threads
    public long member2 = 67890;//shared among both threads

}
