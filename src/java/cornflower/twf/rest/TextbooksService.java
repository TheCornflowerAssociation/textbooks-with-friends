/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.rest;

import cornflower.twf.model.Book;
import cornflower.twf.model.BookCopy;
import cornflower.twf.model.Books;
import cornflower.twf.model.Reservation;
import cornflower.twf.model.Reservations;
import cornflower.twf.utils.ActionController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Beast
 */
@Path("/textbookApp")
public class TextbooksService {

    @Context
    private ServletContext application;

    private ActionController getTextbookApp() throws JAXBException, IOException, Exception {
        // The web server can handle requests from different clients in parallel.
        // These are called "threads".
        //
        // We do NOT want other threads to manipulate the application object at the same
        // time that we are manipulating it, otherwise bad things could happen.
        //
        // The "synchronized" keyword is used to lock the application object while
        // we're manpulating it.
        synchronized (application) {
            ActionController textbookApp = (ActionController) application.getAttribute("system");
            if (textbookApp == null) {
                textbookApp = new ActionController(application);
                application.setAttribute("system", textbookApp);
            }
            return textbookApp;
        }
    }

    @Path("/listBooks")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<BookCopy> listBooks(@QueryParam("username") String username, @QueryParam("status") String status, @QueryParam("condition") String condition) throws IOException, Exception {

        ActionController TextbookApp = getTextbookApp();
        Books allBooks = TextbookApp.getBooks();
        Reservations reservations = TextbookApp.getReservations();

        ArrayList<BookCopy> copies = new ArrayList<BookCopy>();
        
        for (Book book : allBooks.getBooks()) {
            for (BookCopy copy : book.getBookCopies()) {

                copies.add(copy);
                
                if (username != null && !copy.getLister().equals(username)) {
                    copies.remove(copy);
                }

                if (status != null) {
                    boolean reserved = false;
                    for (Reservation reservation : reservations.getReservations()) {
                        if (reservation.getCopyId() == copy.getId()) {
                            reserved = true;
                        }
                    }
                    
                    if (status.equals("reserved") && !reserved) {
                        copies.remove(copy);
                    } else if (status.equals("unreserved") && reserved) {
                         copies.remove(copy);
                    }
                    
                }

                if (condition != null && !copy.getCondition().equals(condition)) {
                    copies.remove(copy);
                }

            }
        }

        return copies;
    }
}
