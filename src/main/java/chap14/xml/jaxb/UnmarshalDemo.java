package chap14.xml.jaxb;

import chap14.xml.model.Students;
import helpers.Helper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Stas on 19/02/2015.
 */
public class UnmarshalDemo {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(Students.class);
        Unmarshaller u = context.createUnmarshaller();
        Object unmarshal = u.unmarshal(new FileReader(Helper.PATH14 + "studs_marsh.xml"));
        System.out.println((Students)unmarshal);
    }
}
