package chap14.xml.sax;

import helpers.Helper;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Stas on 19/02/2015.
 */
public class SaxDemo {

    public static void main(String[] args) {

        try {
            // созд ание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            StudentHandler handler = new  StudentHandler();
            reader.setContentHandler(handler);
            reader.parse(Helper.PATH14 + "studs_marsh.xml");
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }

}

