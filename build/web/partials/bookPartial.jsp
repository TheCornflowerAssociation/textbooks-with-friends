<%-- 
    Document   : bookPartial
    Created on : 23/04/2018, 12:49:55 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.model.BookCopy"%>
<% 
    Book book = books.getBook(request.getParameter("isbn"));
    
    if (book != null) {
%>
<div class="card">
    <h4 class="card-header"><%= book.getTitle() %></h4>
    <div class="card-body">
        <h5 class="card-title"><%= book.getAuthor() %></h5>
        <p class="card-text"><b>Description:</b> <%= book.getDescription() %></p>
        <br>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Condition</th>
                    <th scope="col">Reservation Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (BookCopy copy : book.getBookCopies()) {
                %>
                <tr>
                    <th scope="row">1</th>
                    <td><%= copy.getCondition() %></td>
                    <% if (copy.isReserved()) { %>
                        <td><a class="btn btn-default disabled">Reserved</a></td>
                    <% } else { %>
                        <td><a href="#" class="btn btn-default">Reserve this Book</a></td>
                    <% } %>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
<%
    } else {
%>
<div class="card">
    <div class="card-body">
        <h4 class="card-title text-center">Select a book to view from the list</h4>
    </div>
</div>
<% } %>
