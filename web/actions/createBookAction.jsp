<%-- 
    Document   : listAction
    Created on : 27/04/2018, 10:14:48 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.Validator"%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Validator v = new Validator();

    // Get book attributes
    String isbn = request.getParameter("isbn");
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    String author = request.getParameter("author");
    String category = request.getParameter("category");

    // Check if the user is logged in
    Lister lister = (Lister) session.getAttribute("lister");
    if (lister != null) {
        // Validation
        boolean validationsFail = false;

        AppMessage isbnError = v.validIsbn(isbn);
        if (isbnError != null) {
            session.setAttribute("appMessage", isbnError);
            validationsFail = true;
        }

        AppMessage titleError = v.validText(title);
        if (titleError != null) {
            session.setAttribute("appMessage", titleError);
            validationsFail = true;
        }

        AppMessage descriptionError = v.validText(description);
        if (descriptionError != null) {
            session.setAttribute("appMessage", descriptionError);
            validationsFail = true;
        }

        AppMessage authorError = v.validText(author);
        if (authorError != null) {
            session.setAttribute("appMessage", authorError);
            validationsFail = true;
        }

        AppMessage categoryError = v.validText(category);
        if (categoryError != null) {
            session.setAttribute("appMessage", categoryError);
            validationsFail = true;
        }
        
        if (isbn.equals("") || title.equals("") || description.equals("") || author.equals("") || category.equals("")) {
            session.setAttribute("appMessage", new AppMessage("danger", "Please fill in all required fields."));
            validationsFail = true;
        }

        // ----------
        if (validationsFail) {
            response.sendRedirect(request.getHeader("Referer"));
        } else {
            Book book = new Book(isbn, title, author, description, category);
            books.addBook(book);
            ac.commitBookData(books);

            session.setAttribute("appMessage", new AppMessage("success", "Added new book \"" + title + "\""));
            response.sendRedirect("../index.jsp");
        }

    } else {
        session.setAttribute("appMessage", new AppMessage("warning", "You must be logged in to perform this action"));
        response.sendRedirect(request.getHeader("Referer"));
    }
%>