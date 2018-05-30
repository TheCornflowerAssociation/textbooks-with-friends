/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

import cornflower.twf.model.Book;
import cornflower.twf.model.Books;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * A utility class for formatting Java objects into XML.
 * 
 * @author J-Mo
 */
public class XmlParser {
    
    /**
     * Parses a book object into XML using JAXB and returns it as text.
     * 
     * @param book - the book to be formatted
     * @return - the XML as a StringWritter
     * @throws JAXBException - excepts a bad parse
     */
    public static StringWriter parseBook(Book book) throws JAXBException {
        Books fakebooks = new Books();
        fakebooks.addBook(book);
        StringWriter sw = new StringWriter();

        // Boilerplate code to convert objects to XML...
        JAXBContext jc = JAXBContext.newInstance(Book.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(fakebooks, sw);
        return sw;
    }
}
