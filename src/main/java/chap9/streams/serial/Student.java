package chap9.streams.serial;

import java.io.Serializable;

/**
 * Created by Stas on 09/01/2015.
 */
public class Student implements Serializable {

    protected static String faculty;
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 1L;

    public Student(String nameOfFaculty, String name, int id, String password){
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String toString(){

        return "\nfaculty " + faculty + "\nname " + name + "\nID" + id + "\npassword " + password;
    }
}
