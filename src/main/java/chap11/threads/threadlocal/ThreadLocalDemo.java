package chap11.threads.threadlocal;

/**
 * Created by Stanislau_Strelchank on 12/15/2016.
 */
public class ThreadLocalDemo {

  public static class MyRunnable implements Runnable {

    public ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
      @Override
      protected Integer initialValue() {
        return 0;
      }
    };

    private final int value;

    public MyRunnable(int value) {
      this.value = value;
    }

    public void run() {
      threadLocal.set( threadLocal.get() +  value);
      System.out.println("Inside thread " + this);
    }

    @Override
    public String toString() {
      return "Runnable #" + value + " - " + threadLocal.get();
    }
  }

  //
  public static void main( String[] args ) throws InterruptedException {
    for (;true;) {
      MyRunnable runnable1 = new MyRunnable( 1 );
      runnable1.threadLocal.set( 100 );
      MyRunnable runnable2 = new MyRunnable( 2 );
      runnable2.threadLocal.set( 200 );
      new Thread( runnable1 ).start();
      new Thread( runnable2 ).start();

      Thread.sleep( 1000 );

      System.out.println("Inside main" + runnable1);
      System.out.println("Inside main" + runnable2);

      System.out.println("*********************************************");
    }
  }
}
