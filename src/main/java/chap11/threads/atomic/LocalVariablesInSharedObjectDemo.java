package chap11.threads.atomic;

public class LocalVariablesInSharedObjectDemo {

    static class SharedObject{

        //without volatile may be different results
        int var1 = 0;
        int var2 = 0;
    }

    static class ThreadWithSharedObject extends Thread{

        SharedObject object;
        int value;

        public ThreadWithSharedObject(SharedObject object, int value) {
            this.object = object;
            this.value = value;
        }

        @Override
        public void run() {
            object.var1 ++;
            object.var2 ++;
            System.out.println(this.getName() + ":  " + object.var1 + " " + object.var2);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //todo doesn't work as expected
        while (true){
            SharedObject sharedObject = new SharedObject();
            ThreadWithSharedObject thread1 = new ThreadWithSharedObject(sharedObject, 5);
            thread1.setName("thread1");
            ThreadWithSharedObject thread2 = new ThreadWithSharedObject(sharedObject, 10);
            thread2.setName("thread2");
            thread1.start();
            thread2.start();
            Thread.sleep(2500);
            System.out.println("After all:  " + sharedObject.var1 + " " + sharedObject.var2);
        }
    }
}
