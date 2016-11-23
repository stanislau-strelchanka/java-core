package chap9.streams.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Stas on 17/01/2015.
 */
public class PipedStreamsDemo {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream pout=new PipedOutputStream();
        final PipedInputStream pin=new PipedInputStream();

        pin.connect(pout);//connecting the streams
//creating one thread t1 which writes the data
        Thread t1=new Thread(){
            public void run(){
                for(int i=65;i<=90;i++){
                    try{
                        pout.write(i);
                        Thread.sleep(1000);
                    }catch(Exception e){}
                }
            }
        };
//creating another thread t2 which reads the data
        Thread t2=new Thread(){
            public void run(){
                try{
                    for(int i=65;i<=90;i++)
                        System.out.println(pin.read());
                }catch(Exception e){}
            }
        };
//starting both threads
        t1.start();
        t2.start();
    }
}
