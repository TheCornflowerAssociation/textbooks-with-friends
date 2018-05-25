<%-- 
    Document   : listAction
    Created on : 27/04/2018, 10:14:48 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.Validator"%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Validator v = new Validator();

    // Get the book
    String isbn = request.getParameter("isbn");
    Book book = books.getBook(isbn);

    // Get copy attributes
    try {
        String condition = request.getParameter("condition");
        Integer edition = Integer.valueOf(request.getParameter("edition"));
        Integer year = Integer.valueOf(request.getParameter("year"));
        String publisher = request.getParameter("publisher");
        Lister lister = (Lister) session.getAttribute("lister");

        // Check if the user is logged in
        if (lister != null) {
            // Validation
            boolean validationsFail = false;

            AppMessage conditionError = v.validText(condition);
            if (conditionError != null) {
                session.setAttribute("appMessage", conditionError);
                validationsFail = true;
            }

            AppMessage editionError = v.validNumber(String.valueOf(edition));
            if (editionError != null) {
                session.setAttribute("appMessage", editionError);
                validationsFail = true;
            }

            AppMessage yearError = v.validYear(String.valueOf(year));
            if (yearError != null) {
                session.setAttribute("appMessage", yearError);
                validationsFail = true;
            }

            AppMessage publisherError = v.validText(publisher);
            if (publisherError != null) {
                session.setAttribute("appMessage", publisherError);
                validationsFail = true;
            }
            
            if (condition.equals("") || edition == null || year == null || publisher.equals("")) {
                session.setAttribute("appMessage", new AppMessage("danger", "Please fill in all required fields."));
                validationsFail = true;
            }

            // ----------
            if (validationsFail) {
                response.sendRedirect(request.getHeader("Referer"));
            } else {
                // Add the copy
                BookCopy copy = new BookCopy(book.getNewId(), condition, edition, year, publisher, lister.getEmail());
                book.addBookCopy(copy);
                books.setBook(isbn, book);
                ac.commitBookData(books);

                session.setAttribute("appMessage", new AppMessage("success", "Added new book copy for \"" + book.getTitle() + "\""));
                response.sendRedirect("../index.jsp");
            }

        } else {
            session.setAttribute("appMessage", new AppMessage("warning", "You must be logged in to perform this action"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    } catch (Exception e) {
        session.setAttribute("appMessage", new AppMessage("danger", "Some validations failed, this is the warning message"));
        response.sendRedirect(request.getHeader("Referer"));
    }
%>