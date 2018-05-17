<%-- 
    Document   : listAction
    Created on : 27/04/2018, 10:14:48 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    
    // Get the book
    String isbn = request.getParameter("isbn");
    Book book = books.getBook(isbn);
    
    // Get copy attributes
    String condition = request.getParameter("condition");
    int edition = Integer.valueOf(request.getParameter("edition"));
    int year = Integer.valueOf(request.getParameter("year"));
    String publisher = request.getParameter("publisher");
    Lister lister = (Lister) session.getAttribute("lister");
    
    // Check if the user is logged in
    if (lister != null) {
        // Add the copy
        BookCopy copy = new BookCopy(book.getNewId(), condition, edition, year, publisher, lister.getEmail());
        book.addBookCopy(copy);
        books.setBook(isbn, book);
        ac.commitBookData(books);
    }
    session.setAttribute("appMessage", new AppMessage("success", "Added new book copy for \"" + book.getTitle() + "\""));
    response.sendRedirect("../index.jsp");
%>