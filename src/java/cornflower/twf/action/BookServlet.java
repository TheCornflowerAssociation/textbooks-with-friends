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
 *
 * @author J-Mo
 */
@WebServlet("/action/book")
public class BookServlet extends javax.servlet.http.HttpServlet {
    
    // Fields
    ActionController ac;
    HttpSession session;
    Books books;
    
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
        setFields(request, response);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equalsIgnoreCase("delete")) {
            doDestroy(request, response);
        }
        else {
            doCreate(request, response);
        }
    }
    
    private void doDestroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String isbn = request.getParameter("isbn");
        Lister lister = (Lister) session.getAttribute("lister");

        Book book = books.getBook(isbn);
        
        if (book.getBookCopiesAmount() > 0) {
            session.setAttribute("appMessage", new AppMessage("warning", "Cannot remove books with active copy listings"));
            response.sendRedirect(request.getHeader("Referer"));
        }
        else {
        
            // Remove the book
            books.removeBook(book);
            try {
                ac.commitBookData(books);
            } catch (Exception ex) {
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect(request.getHeader("Referer"));
            }

            session.setAttribute("appMessage", new AppMessage("success", "Removed book \"" + book.getTitle() + "\" from listings"));
            response.sendRedirect("../index.jsp");
        }
    }
    
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
        // Validation
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
            response.sendRedirect(request.getHeader("Referer"));
        } else {
            Book book = new Book(isbn, title, author, description, category);
            books.addBook(book);
            try {
                ac.commitBookData(books);
            } catch (Exception ex) {
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect("../index.jsp");
            }

            session.setAttribute("appMessage", new AppMessage("success", "Added new book \"" + title + "\""));
            response.sendRedirect("../index.jsp");
        }
    }
}