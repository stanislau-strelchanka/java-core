package chap11.threads;

/**
 * Created by Stas on 13/01/2015.
 */
public class PriorityThreadDemo extends Thread {

    public PriorityThreadDemo(String name){

        super(name);
    }

    public void run(){

        for (int i = 0; i < 71; i++) {

            System.out.println(getName() + " " + i);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        PriorityThreadDemo min = new PriorityThreadDemo("Min");
        PriorityThreadDemo max = new PriorityThreadDemo("Max");
        PriorityThreadDemo norm = new PriorityThreadDemo("Norm");

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }
}
