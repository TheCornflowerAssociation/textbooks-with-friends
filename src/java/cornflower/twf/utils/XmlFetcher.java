/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

import cornflower.twf.model.Book;
import cornflower.twf.model.BookCopy;
import cornflower.twf.model.Books;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author J-Mo
 */
public class XmlFetcher {
    
    public static StringWriter getBooksList(ArrayList<Book> books) throws JAXBException {
        Books fakebooks = new Books();
        fakebooks.setBooks(books);

        StringWriter sw = new StringWriter();

        // Boilerplate code to convert objects to XML...
        JAXBContext jc = JAXBContext.newInstance(Books.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(fakebooks, sw);
        return sw;
    }
    
    public static StringWriter getBook(Book book) throws JAXBException {
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
    
    public static StringWriter getCopiesList(ArrayList<BookCopy> copies, String isbn) throws JAXBException {
        Book fakebook = new Book();
        fakebook.setIsbn(isbn);
        fakebook.setBookCopies(copies);

        StringWriter sw = new StringWriter();

        // Boilerplate code to convert objects to XML...
        JAXBContext jc = JAXBContext.newInstance(BookCopy.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(fakebook, sw);
        return sw;
    }
    
}
