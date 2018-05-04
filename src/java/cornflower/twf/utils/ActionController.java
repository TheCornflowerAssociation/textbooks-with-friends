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
 *
 * @author J-Mo
 */
public class ActionController {
    
    private ServletContext application;
    private TextbookSystem system;
    
    public ActionController(ServletContext application) throws Exception {
        this.application = application;
        String usersFilePath = application.getRealPath("WEB-INF/users.xml");
        String booksFilePath = application.getRealPath("WEB-INF/books.xml");
        String reservationsFilePath = application.getRealPath("WEB-INF/reservations.xml");
        this.system = new TextbookSystem(usersFilePath, booksFilePath, reservationsFilePath);
        system.updateFields();
    }
    
    public Users getUsers() {
        return system.getUsers();
    }
    
    public Books getBooks() {
        return system.getBooks();
    }
    
    public Reservations getReservations() {
        return system.getReservations();
    }
    
    public void commitUserData(Users users) throws Exception {
        system.setUsers(users);
        system.updateXml();
    }
    
    public void commitBookData(Books books) throws Exception {
        system.setBooks(books);
        system.updateXml();
    }
    
    public void commitReservationData(Reservations reservations) throws Exception {
        system.setReservations(reservations);
        system.updateXml();
    }
}
