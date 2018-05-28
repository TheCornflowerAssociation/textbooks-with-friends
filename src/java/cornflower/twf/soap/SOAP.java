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
import cornflower.twf.utils.ActionController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBException;

/**
 *
 * @author rubrixs
 */
@WebService(serviceName = "SOAP")
public class SOAP {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @Context
    private ServletContext application;
    
    
    private ActionController getListerApp() throws JAXBException, IOException, Exception {
        synchronized (application) {
            ActionController listerApp = (ActionController) application.getAttribute("system");
            if (listerApp == null) {
                listerApp = new ActionController(application);
                application.setAttribute("system", listerApp);
            }
            return listerApp;
        }
    }
    
    private ActionController getTextbookApp() throws JAXBException, IOException, Exception {
        synchronized (application) {
            ActionController textbookApp = (ActionController) application.getAttribute("system");
            if (textbookApp == null) {
                textbookApp = new ActionController(application);
                application.setAttribute("system", textbookApp);
            }
            return textbookApp;
        }
    }
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "listerLogin")
    public Lister listerLogin(String email, String password) throws IOException, JAXBException, Exception {
        ArrayList<Lister> list = getListerApp().getUsers().getListers();
        for (Lister lister:list)
        {
            if (lister.getEmail().equals(email) && lister.getPassword().equals(password))
                return lister;
        }
        return null;
    }
    
    @WebMethod(operationName = "fetchAllTextbooks")
    public ArrayList<Book> fetchAllTextbooks() throws IOException, Exception {
       
        return null;
    }
}
