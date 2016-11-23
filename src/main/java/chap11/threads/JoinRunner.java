package chap11.threads;

/**
 * Created by Stas on 13/01/2015.
 */
public class JoinRunner {

    static public class JoinThread extends Thread {

        public JoinThread(String name){
            super(name);
        }

        public void run(){

            String nameT = getName();
            long timeout = 0;
            System.out.println("Старт потока " + nameT);

            try{
                if(nameT.equals("First")) {
                    timeout = 5000;
                }
                else if(nameT.equals("Second")){

                    timeout = 1000;
                }

                Thread.sleep(timeout);
                System.out.println("Конец потока " + nameT);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static{
        System.out.println("Старт потока main");
    }

    public static void main(String[] args) throws InterruptedException {

        JoinThread t1 = new JoinThread("First");
        JoinThread t2 = new JoinThread("Second");

        t1.start();
        t2.start();

        t1.join(); //поток main будет остановлен до окончания работы потока t1

        System.out.println(Thread.currentThread().getName());
    }
}
