package chap14.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import chap14.xml.model.Student;
import java.util.HashSet;
import java.util.Set;


public class StudentBuilderHandler extends DefaultHandler {

    private EnumSet<StudentEnum> withText = EnumSet.range(StudentEnum.NAME,StudentEnum.STREET);
    private Set<Student> students = new HashSet<Student>();
    private Student current = null;
    private StudentEnum currentEnum = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if("student".equals(qName) || "abiturient".equals(qName)){
            current = new Student();
            current.setLogin(attributes.getValue(0));
            if(attributes.getLength() == 2){
                current.setFaculty(attributes.getValue(1));
            }
        }
        else{

            for (StudentEnum studentEnum : withText) {
                if(studentEnum.getValue().equals(localName))
                    currentEnum = studentEnum;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("student".equals(qName)){
            students.add(current);
            current = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String s = new String(ch,start,length);
        if(currentEnum != null){
            switch (currentEnum){
                case NAME:
                    current.setName(s);
                    break;
                case TELEPHONE:
                    current.setTelephone(Integer.parseInt(s));
                    break;
                case STREET:
                    current.getAddress().setStreet(s);
                    break;
                case CITY:
                    current.getAddress().setCity(s);
                    break;
                case COUNTRY:
                    current.getAddress().setCountry(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
            currentEnum = null;
        }
    }

    Set<Student> getStudents(){

        return this.students;
    }
}
