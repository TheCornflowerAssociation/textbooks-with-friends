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
    
    
    String isbn = request.getParameter("isbn");
    Book book = books.getBook(isbn);
    
    
    int copyId = Integer.parseInt(request.getParameter("copyId"));
    BookCopy bookCopy = book.getBookCopy(copyId);
    
    
    bookCopy.setReserved(true);
    
    
    book.setBookCopy(copyId, bookCopy);
    books.setBook(isbn, book);
    ac.commitBookData(books);
    
    
    response.sendRedirect("../index.jsp");
%>
