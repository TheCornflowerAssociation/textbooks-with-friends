<%-- 
    Document   : listAction
    Created on : 27/04/2018, 10:14:48 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    
    // Get book attributes
    String isbn = request.getParameter("isbn");
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    String author = request.getParameter("author");
    String category = request.getParameter("category");
    
    // Check if the user is logged in
    Lister lister = (Lister) session.getAttribute("lister");
    if (lister != null) {
        Book book = new Book(isbn, title, author, description, category);
        books.addBook(book);
        ac.commitBookData(books);
    }
    session.setAttribute("appMessage", new AppMessage("success", "Added new book \"" + title + "\""));
    response.sendRedirect("../index.jsp");
%>