package chap9.streams.serial;

import java.io.*;

/**
 * Created by Stas on 09/01/2015.
 */
public class Serializator {

    public boolean serialization(Student s, String fileName){

        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;

        try{
            FileOutputStream fos = new FileOutputStream(f);
            if(fos != null){
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(s);
                flag = true;
            }
        }catch(IOException e){
            //
        }finally {
            if(ostream != null){
                try {
                    ostream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    public Student deserialization(String filename){

        File fr = new File(filename);
        ObjectInputStream istream = null;
        try{
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            Student student = (Student) istream.readObject();
            return student;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

            try{
                if(istream != null){
                    istream.close();
                }
            }catch (IOException e){

            }
        }
        return null;
    }
}
