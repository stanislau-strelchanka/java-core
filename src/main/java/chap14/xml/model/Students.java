package chap14.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Stas on 19/02/2015.
 */

@XmlRootElement
public class Students {

    @XmlElement(name="student")
    private ArrayList<Student> list = new ArrayList<Student>();

    public Students(){
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
    public boolean add(Student st) {
        return list.add(st);
    }
    @Override
    public String toString() {
        return "Students [list=" + list + "]";
    }

}
