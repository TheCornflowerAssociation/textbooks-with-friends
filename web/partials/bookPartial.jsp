<%-- 
    Document   : bookPartial
    Created on : 23/04/2018, 12:49:55 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.XmlFetcher"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<% 
    Book book = books.getBook(request.getParameter("isbn"));
    
    if (book != null) {
        
        ArrayList<BookCopy> copies;
        
        if (filter != null && filter.equals("myListings")) {
            copies = book.getCopiesByLister(currentUser.getEmail());
        }
        else if (filter != null && filter.equals("unreserved")) {
            copies = book.getUnreservedCopies(reservations);
        }
        else {
            copies = book.getBookCopies();
        }
        
        book.setBookCopies(copies);
%>
<%
    StringWriter bookXmlText = XmlFetcher.getBook(book);
%>

<c:set var = "bookXml">
    <%= bookXmlText %>
</c:set>

<c:import url="/WEB-INF/book.xsl" var="xslt"/>
<x:transform xml="${bookXml}" xslt="${xslt}"/>
<%
    } else {
%>
<div class="card">
    <div class="card-body">
        <h4 class="card-title text-center">Select a book to view from the list</h4>
    </div>
</div>
<% } %>
