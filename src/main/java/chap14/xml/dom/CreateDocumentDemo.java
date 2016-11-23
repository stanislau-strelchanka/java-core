package chap14.xml.dom;

import helpers.Helper;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Stas on 20/02/2015.
 */
public class CreateDocumentDemo {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("book");
        Element name = document.createElement("name");
        Element author = document.createElement("author");
        Attr id = document.createAttribute("id");
        id.setTextContent("333");
        author.setAttributeNode(id);
        document.appendChild(root);
        root.appendChild(name);
        root.appendChild(author);
        name.setTextContent("aaa");
        author.setTextContent("bbb");


        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult sr = new StreamResult(Helper.PATH14 + "students_dom.xml");
        transformer.transform(domSource,sr);
    }

}
