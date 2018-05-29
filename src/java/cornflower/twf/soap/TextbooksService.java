/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import cornflower.twf.model.Users;
import cornflower.twf.model.Lister;
import cornflower.twf.model.Books;
import cornflower.twf.model.Book;
import cornflower.twf.model.BookCopy;
import cornflower.twf.utils.ActionController;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author rubrixs
 */
@WebService(serviceName = "TextbooksService")
public class TextbooksService {

    @Resource
    private WebServiceContext context;

    private ActionController getTextbookApp() throws Exception {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        ActionController textbookApp = (ActionController) application.getAttribute("textbookApp");
        if (textbookApp == null) {
            textbookApp = new ActionController(application);
            application.setAttribute("textbookApp", textbookApp);
        }
        return textbookApp;
    }
    
    private boolean isLister(String email, String password) throws IOException, Exception {
        ActionController textbookApp = getTextbookApp();
        ArrayList<Lister> listers = textbookApp.getUsers().getListers();
        
        for (Lister lister : listers) {
            if (lister.getEmail().equals(email) && lister.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isLister(String email, String password, Book book) throws Exception {
        if (isLister(email, password)) {
            return book.hasLister(email);
        }
        return false;
    }
    
    @WebMethod
    public String listBook(String email, String password, String isbn, String title, String description, String author, String category, String condition, int edition, int year, String publisher, String lister) throws IOException, JAXBException, Exception {
        Book book = new Book(isbn, title, author, description, category);
        int id = book.getNewId();
        
        BookCopy copy = new BookCopy(id, condition, edition, year, publisher, lister);
        book.addBookCopy(copy);
        
        if (isLister(email, password)) {
            getTextbookApp().getBooks().addBook(book);
            
            return book.getIsbn();
        }
        return null;
    }
    
    @WebMethod
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Book> fetchBooks() throws IOException, Exception {
       return getTextbookApp().getBooks().getBooks();
    }
    
    @WebMethod
    public boolean deleteBook(String email, String password, String isbn) throws Exception {
        Book book = getTextbookApp().getBooks().getBook(isbn);
        if (isLister(email, password, book)) {
            getTextbookApp().getBooks().removeBook(book);
            return true;
        }
        return false;
    }
}
