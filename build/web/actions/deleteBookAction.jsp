<%-- 
    Document   : deleteAction
    Created on : 23/04/2018, 12:48:41 PM
    Author     : J-Mo
--%>


<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Reservations reservations = ac.getReservations();
    Books books = ac.getBooks();
    
    String isbn = request.getParameter("isbn");
    Lister lister = (Lister) session.getAttribute("lister");
    
    Book book = books.getBook(isbn);
    if (lister != null) {
        // Remove the book
        books.removeBook(book);
        ac.commitBookData(books);
    }
    
    response.sendRedirect("../index.jsp");
%>