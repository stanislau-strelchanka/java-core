package chap14.xml.dom;

import chap14.xml.model.Student;
import helpers.Helper;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stas on 20/02/2015.
 */
public class BuilderDemo {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Set<Student> students = new HashSet<Student>();
        Student current = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(Helper.PATH14 + "studs_marsh.xml"));

        Element root = document.getDocumentElement();
        NodeList studentsElem = root.getElementsByTagName("student");
        for (int i = 0; i < studentsElem.getLength(); i++) {

            Student student = new Student();
            Element studentElement = (Element)studentsElem.item(i);
            // заполнение объекта student
            student.setFaculty(studentElement.getAttribute("faculty")); // проверка на null
            student.setName(getElementTextContent(studentElement, "name"));
            Integer tel = Integer.parseInt(getElementTextContent(studentElement,
                    "telephone"));
            student.setTelephone(tel);
            Student.Address address = student.getAddress();
            // заполнение объекта address
            Element adressElement = (Element) studentElement.getElementsByTagName(
            "address").item(0);
            address.setCountry(getElementTextContent(adressElement, "country"));
            address.setCity(getElementTextContent(adressElement, "city"));
            address.setStreet(getElementTextContent(adressElement, "street"));
            student.setLogin(studentElement.getAttribute("login"));
            students.add(student);
        }
        System.out.println(students);
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
