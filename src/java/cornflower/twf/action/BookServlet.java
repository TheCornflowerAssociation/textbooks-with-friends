/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.action;

import cornflower.twf.model.Books;
import cornflower.twf.model.Book;
import cornflower.twf.model.Lister;
import cornflower.twf.utils.ActionController;
import cornflower.twf.utils.AppMessage;
import cornflower.twf.utils.Validator;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet class for the book object that services the /action/book route.
 * 
 * @author J-Mo
 */
@WebServlet("/action/book")
public class BookServlet extends javax.servlet.http.HttpServlet {
    
    // Fields
    ActionController ac;
    HttpSession session;
    Books books;
    
    /**
     * A helper method that sets up the fields before jumping into the request
     * action. Also reroutes in the case of an exception.
     * 
     * @param request - the request object
     * @param response - the response object
     * @throws IOException - excepts null referrer status 
     */
    private void setFields(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ac = new ActionController(request.getServletContext());
            session = request.getSession();
            books = ac.getBooks();
        } catch (Exception ex) {
            session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the fields
        setFields(request, response);
        
        // Get the action method
        String action = request.getParameter("action");
        
        // Check if POST is actually a DELETE
        if (action != null && action.equalsIgnoreCase("delete")) {
            // Run the destroy path
            doDestroy(request, response);
        }
        else {
            // Run the post path
            doCreate(request, response);
        }
    }
    
    /**
     * A helper method that runs the actions for a destroy request.
     * 
     * @param request - the request object
     * @param response - the response object
     * @throws IOException - excepts null referrer status
     */
    private void doDestroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the params
        String isbn = request.getParameter("isbn");
        Lister lister = (Lister) session.getAttribute("lister");
        
        // Get the book by its ISBN
        Book book = books.getBook(isbn);
        
        if (book.getBookCopiesAmount() > 0) {
            // Redirect if there are still book copies owned by the book
            session.setAttribute("appMessage", new AppMessage("warning", "Cannot prune books with active copy listings"));
            response.sendRedirect(request.getHeader("Referer"));
        }
        else {
        
            // Remove the book
            books.removeBook(book);
            try {
                // Commit the change
                ac.commitBookData(books);
            } catch (Exception ex) {
                // Message the user about bad commit
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect(request.getHeader("Referer"));
            }

            // Return success message to the user
            session.setAttribute("appMessage", new AppMessage("success", "Removed book \"" + book.getTitle() + "\" from listings"));
            response.sendRedirect("../index.jsp");
        }
    }
    
    /**
     * A helper method that runs the actions for a create request.
     * 
     * @param request - the request object
     * @param response - the response object
     * @throws IOException - excepts null referrer status
     */
    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Validator v = new Validator();

        // Get book attributes
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String category = request.getParameter("category");

        // Check if the user is logged in
        Lister lister = (Lister) session.getAttribute("lister");
        
        // Perform field validations
        boolean validationsFail = false;

        AppMessage isbnError = v.validIsbn(isbn);
        if (isbnError != null) {
            session.setAttribute("appMessage", isbnError);
            validationsFail = true;
        }

        AppMessage titleError = v.validText(title, "title");
        if (titleError != null) {
            session.setAttribute("appMessage", titleError);
            validationsFail = true;
        }

        AppMessage descriptionError = v.validText(description, "description");
        if (descriptionError != null) {
            session.setAttribute("appMessage", descriptionError);
            validationsFail = true;
        }

        AppMessage authorError = v.validText(author, "author");
        if (authorError != null) {
            session.setAttribute("appMessage", authorError);
            validationsFail = true;
        }

        AppMessage categoryError = v.validText(category, "category");
        if (categoryError != null) {
            session.setAttribute("appMessage", categoryError);
            validationsFail = true;
        }

        if (isbn.equals("") || title.equals("") || description.equals("") || author.equals("") || category.equals("")) {
            session.setAttribute("appMessage", new AppMessage("danger", "Please fill in all required fields."));
            validationsFail = true;
        }

        if (validationsFail) {
            // Return the validation failure message to the user
            response.sendRedirect(request.getHeader("Referer"));
        } else {
            if (books.getBook(isbn) != null) {
                // Return success message to the user
                session.setAttribute("appMessage", new AppMessage("danger", "Book with ISBN \"" + isbn + "\" is already listed"));
                response.sendRedirect(request.getHeader("Referer"));
            }
            else {
                // Create and commit the book
                Book book = new Book(isbn, title, author, description, category);
                books.addBook(book);
                try {
                    ac.commitBookData(books);
                } catch (Exception ex) {
                    // Message the user about bad commit
                    session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                    response.sendRedirect("../index.jsp");
                }

                // Return success message to the user
                session.setAttribute("appMessage", new AppMessage("success", "Added new book \"" + title + "\""));
                response.sendRedirect("../index.jsp");
            }
        }
    }
}