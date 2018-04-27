<%-- 
    Document   : reserveAction
    Created on : 23/04/2018, 12:47:23 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Book book = books.getBook(request.getParameter("isbn"));
    BookCopy bookCopy = book.getBookCopy(Integer.parseInt(request.getParameter("copyId")));
    bookCopy.setReserved(true);
    ac.commitBookData(books);
    response.sendRedirect("../index.jsp");
%>
