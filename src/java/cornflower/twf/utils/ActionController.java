/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;
import cornflower.twf.model.Books;
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
        this.system = new TextbookSystem(usersFilePath, booksFilePath);
        system.updateFields();
    }
    
    public Users getUsers() {
        return system.getUsers();
    }
    
    public Books getBooks() {
        return system.getBooks();
    }
    
    public void commitUserData(Users users) throws Exception {
        system.setUsers(users);
        system.updateXml();
    }
    
    public void commitBookData(Books books) throws Exception {
        system.setBooks(books);
        system.updateXml();
    }
}
