<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="java.util.ArrayList"%>
<% 
    // Get the books and apply the relevant filter settings
    ArrayList<Book> booksList;
%>
<h2 class="text-center">
    <% if (currentUser != null && filter != null && filter.equals("myListings")) {
        booksList = books.getBooksByLister(currentUser.getEmail());
    %>
        <span>My Listings</span>
    <% } else if (filter != null && filter.equals("unreserved")) {
        booksList = books.getUnreservedBooks(reservations);
    %>
        <span>Unreserved Books</span>
    <% } else {
        booksList = books.getBooks();
    %>
        <span>All Books</span>
    <% } %>
</h2>
<br>
<div class="card">
    <div class="card-body">
        <ul class="list-group list-group-flush">
            <!--Display each book in the list-->
            <% for (Book book : booksList) { %>
                <li class="list-group-item">
                    <a href="index.jsp?<%= filter != null ? "filter=" + filter : "" %>&isbn=<%= book.getIsbn() %>">
                        <h5><%= book.getTitle() %></h5>
                    </a>
                    <p>by <%= book.getAuthor() %></p>
                    <!--Show categories-->
                    <p><%@include file="categoriesPartial.jsp" %></p>
                </li>
            <% } %>
        </ul>
        <% if (booksList.size() < 1) { %>
            <!--Display a message-->
            <h5 class="text-center">No books to display</h5>
        <% } %>
    </div>
</div>
