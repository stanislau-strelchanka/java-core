package chap11.threads.synchro;

class StringBufferDemo {

    static int counter = 0;
    static StringBuffer s = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            public void run(){
                synchronized (s){
                    while (StringBufferDemo.counter++ < 3){
                        s.append("A");
                        System.out.print("> " + counter + " ");
                        System.out.println(s);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        Thread.sleep(100);

        while (StringBufferDemo.counter++ < 6){
            System.out.print("< " + counter + " ");
            s.append("B");// main will be waiting for s release
            System.out.println(s);
        }
    }
}
