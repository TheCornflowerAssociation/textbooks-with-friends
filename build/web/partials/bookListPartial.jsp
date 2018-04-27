<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="java.util.ArrayList"%>
<% 
    boolean hasSelfListingFilter = request.getParameter("myListings") != null;
    ArrayList<Book> booksList;
%>
<h2 class="text-center">
    <% if (hasSelfListingFilter) {
        booksList = books.getBooksByLister(((Lister)session.getAttribute("lister")).getEmail());
    %>
        <span>My Listings </span>
    <% } else {
        booksList = books.getBooks();
    %>
        <span>All Books </span>
    <% } %>
    <span>(<%= booksList.size() %>)</span>
</h2>
<br>
<div class="card">
    <div class="card-body">
        <ul class="list-group list-group-flush">
            <% for (Book b : booksList) { %>
                <li class="list-group-item">
                    <a href="index.jsp?<%= hasSelfListingFilter ? "myListings" : "" %>&isbn=<%= b.getIsbn() %>"><h3><%= b.getTitle() %></h3></a>
                    <p>by <%= b.getAuthor() %></p>
                </li>
            <% } %>
        </ul>
    </div>
</div>
