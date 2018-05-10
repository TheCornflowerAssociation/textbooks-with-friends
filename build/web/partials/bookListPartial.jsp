<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="java.util.ArrayList"%>
<% 
    ArrayList<Book> booksList;
%>
<h2 class="text-center">
    <% if (currentUser != null && filter != null && filter.equals("myListings")) {
        booksList = books.getBooksByLister(currentUser.getEmail());
    %>
        <span>My Listings </span>
    <% } else if (filter != null && filter.equals("unreserved")) {
        booksList = books.getUnreservedBooks(reservations);
    %>
        <span>Unreserved Books </span>
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
                    <a href="index.jsp?<%= filter != null ? "filter=" + filter : "" %>&isbn=<%= b.getIsbn() %>">
                        <h5><%= b.getTitle() %></h5>
                    </a>
                    <p>by <%= b.getAuthor() %> | <span class="badge badge-primary"><%= b.getCategory() %></span></p>
                </li>
            <% } %>
        </ul>
    </div>
</div>
