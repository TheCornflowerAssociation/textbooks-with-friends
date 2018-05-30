<%-- 
    Document   : bookPartial
    Created on : 23/04/2018, 12:49:55 PM
    Author     : J-Mo
--%>

<%@page import="java.io.StringWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.utils.XmlParser"%>
<% 
    // Get the book
    Book book = books.getBook(request.getParameter("isbn"));
    
    if (book != null) {
        
        // Filter the book copies
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
        
        // Set the displayed book to only show books for that filter
        book.setBookCopies(copies);
        
        // Get the xml for the book using the parser
        StringWriter bookXmlText = XmlParser.getBook(book);
%>

    <!--Create an XML variable to pass with the XSL file-->
    <c:set var = "bookXml">
        <%= bookXmlText %>
    </c:set>

    <!--Display the book as HTML using XSLT-->
    <c:import url="/WEB-INF/book.xsl" var="xslt"/>
    <x:transform xml="${bookXml}" xslt="${xslt}"/>
    <%
        } else {
            // Display a message
    %>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title text-center">Select a book to view from the list</h4>
        </div>
    </div>
<% } %>
