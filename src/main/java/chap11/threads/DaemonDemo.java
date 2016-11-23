package chap11.threads;

/**
 * Created by Stas on 13/01/2015.
 */
public class DaemonDemo {

    static public class SimpleThread extends Thread {

        public void run(){

            try{
                if(isDaemon()){
                    System.out.println("старт потока-даемона");
                    Thread.sleep(10000);
                }else{
                    System.out.println("старт обычного потока");
                    //Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(!isDaemon()){
                    System.out.println("завершение обычного потока");
                } else{
                    System.out.println("завершение потока даемона");
                }
            }
        }
    }

    public static void main(String[] args) {

        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();

        daemon.setDaemon(true);
        daemon.start();
        usual.start();

        System.out.println("последний оператор main");
    }
}
