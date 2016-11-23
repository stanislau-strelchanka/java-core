package chap14.xml.jaxb;

import chap14.xml.model.Student;
import chap14.xml.model.Students;
import helpers.Helper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Stas on 19/02/2015.
 */
public class MarshalDemo {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller m = context.createMarshaller();
        Students students = new Students() {
            {
                Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
                Student s = new Student("gochette", "Klimenko", "mmf", 2095306, addr);
                this.add(s);
                // добавление второго студента
                addr = new Student.Address("BLR", "Polotesk", "Simeona P. 23");
                s = new Student("ivette", "Teran", "mmf", 2345386, addr);
                this.add(s);
            }
        };
        m.marshal(students, new FileOutputStream(Helper.PATH14 + "studs_marsh.xml"));
        m.marshal(students,System.out);
    }
}
