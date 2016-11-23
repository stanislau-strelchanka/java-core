package chap11.threads.deadlocks;

/**
 * Created by Stas on 16/01/2015.
 */
public class TreeNodeDemo {

    public static void main(String[] args) throws InterruptedException {


        while(true){
            final TreeNode parent = new TreeNode();
            final TreeNode child = new TreeNode();
            Thread thread1 = new Thread() {

                public void run() {
                    parent.addChild(child);
                }
            };
            thread1.start();

            //Thread.sleep(10); preventing deadlock
            Thread thread2 = new Thread() {

                public void run() {
                    child.setParent(parent);
                }
            };
            thread2.start();

            thread1.join();
            thread2.join();
        }

    }
}
