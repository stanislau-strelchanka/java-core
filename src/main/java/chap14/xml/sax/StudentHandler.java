package chap14.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Stas on 19/02/2015.
 */
public class StudentHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

        String s = uri + qName;
        // получение и вывод информации об атрибутах элемента
        for (int i = 0; i < attrs.getLength(); i++) {
            s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
        }
        System.out.println(s.trim());
    }

    @Override
    public void characters(char[ ] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(localName);
    }

}
