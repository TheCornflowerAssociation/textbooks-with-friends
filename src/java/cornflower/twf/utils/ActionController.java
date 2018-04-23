/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

import cornflower.twf.model.Books;
import cornflower.twf.model.Users;
import javax.servlet.ServletContext;
import cornflower.twf.model.System;

/**
 *
 * @author J-Mo
 */
public class ActionController {
    
    private ServletContext application;
    private String usersFilePath;
    private String booksFilePath;
    
    private System system;
    
    public ActionController(ServletContext application) throws Exception {
        this.application = application;
        this.usersFilePath = application.getRealPath("WEB-INF/users.xml");
        this.booksFilePath = application.getRealPath("WEB-INF/books.xml");
        this.system = new System();
        system.setFilePath(usersFilePath, booksFilePath);
    }
    
    public Users getUsers() {
        return system.getUsers();
    }
    
    public Books getBooks() {
        return system.getBooks();
    }
}
