package chap14.xml.sax;

import chap14.xml.model.Student;
import helpers.Helper;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;


public class SaxBuilderDemo {

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader reader = XMLReaderFactory.createXMLReader();
        StudentBuilderHandler sb = new StudentBuilderHandler();
        reader.setContentHandler(sb);
        reader.parse(Helper.PATH14 + "students.xml");
        Set<Student> students = sb.getStudents();
        System.out.println(students);
    }
}
