/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;
import cornflower.twf.model.Books;
import cornflower.twf.model.Reservations;
import cornflower.twf.model.Users;
import javax.servlet.ServletContext;
import cornflower.twf.model.TextbookSystem;


/**
 * A utility class used to separate the concerns of handling persistence
 * actions and adds a layer of abstraction to the persistence.
 * 
 * @author J-Mo
 */
public class ActionController {
    
    // Fields
    private ServletContext application;
    private TextbookSystem system;
    
    /**
     * A constructor for the ActionController.
     * 
     * @param application - servlet context
     * @throws Exception - excepts from fetching data from the XML
     */
    public ActionController(ServletContext application) throws Exception {
        this.application = application;
        String usersFilePath = application.getRealPath("WEB-INF/users.xml");
        String booksFilePath = application.getRealPath("WEB-INF/books.xml");
        String reservationsFilePath = application.getRealPath("WEB-INF/reservations.xml");
        this.system = new TextbookSystem(usersFilePath, booksFilePath, reservationsFilePath);
        system.updateFields();
    }
    
    /**
     * Commits and persists user data to the XML.
     * 
     * @param users - the users object to be committed
     * @throws Exception - excepts from failure to commit data properly
     */
    public void commitUserData(Users users) throws Exception {
        system.setUsers(users);
        system.updateXml();
    }
    
    /**
     * Commits and persists book data to the XML.
     * 
     * @param books - the books object to be committed
     * @throws Exception - excepts from failure to commit data properly
     */
    public void commitBookData(Books books) throws Exception {
        system.setBooks(books);
        system.updateXml();
    }
    
    /**
     * Commits and persists reservation data to the XML.
     * 
     * @param reservations - the reservations object to be committed
     * @throws Exception - excepts from failure to commit data properly
     */
    public void commitReservationData(Reservations reservations) throws Exception {
        system.setReservations(reservations);
        system.updateXml();
    }
    
    // Getters
    public Users getUsers() {
        return system.getUsers();
    }
    
    public Books getBooks() {
        return system.getBooks();
    }
    
    public Reservations getReservations() {
        return system.getReservations();
    }
}
