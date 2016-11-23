package chap11.threads.synchro;

import helpers.Helper;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Stas on 13/01/2015.
 */

class Resource {

    private FileWriter fileWriter;

    public Resource(String file)throws IOException{
        fileWriter = new FileWriter(file,true);
    }

    public synchronized void writing(String str, int i){
        try {
            fileWriter.append(str + i);
            System.out.print(str + i);
            Thread.sleep((long)(Math.random() * 50));
            fileWriter.append("->" + i + " ");
            System.out.print("->" + i + " ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close(){

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class SynchDemo extends Thread {

    public static void main(String[] args) {

        Resource s = null;
        try {
            s = new Resource(Helper.PATH11 + "result.txt");
            SyncThread first = new SyncThread("First", s);
            SyncThread second = new SyncThread("Second", s);
            second.start();
            first.start();
            first.join();
            second.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}

class SyncThread extends Thread {

    private Resource rs;

    public SyncThread(String name, Resource rs) {

        super(name);
        this.rs = rs;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            rs.writing(getName(), i);
        }

    }
}


