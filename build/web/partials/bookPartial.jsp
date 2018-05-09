<%-- 
    Document   : bookPartial
    Created on : 23/04/2018, 12:49:55 PM
    Author     : J-Mo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<% 
    Book book = books.getBook(request.getParameter("isbn"));
    
    if (book != null) {
        
        ArrayList<BookCopy> copies;
        
        if (hasSelfListingFilter) {
            copies = book.getCopiesByLister(currentUser.getEmail());
        }
        else {
            copies = book.getBookCopies();
        }
%>
<div class="card">
    <h4 class="card-header"><%= book.getTitle() %></h4>
    <div class="card-body">
        <h5 class="card-title">by <%= book.getAuthor() %> | <span class="badge badge-primary"><%= book.getCategory() %></span></h5>
        <p class="card-text"><b>ISBN:</b> <%= book.getIsbn() %></p>
        <p class="card-text"><b>Description:</b> <%= book.getDescription() %></p>
        <br>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Condition</th>
                    <th scope="col">Edition</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">Year</th>
                    <th scope="col">Status</th>
                    <th scope="col">Lister</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (BookCopy copy : copies) {
                %>
                <tr>
                    <th><%= copy.getId() %></th>
                    <td><%= copy.getCondition() %></td>
                    <td><%= copy.getEdition() %></td>
                    <td><%= copy.getPublisher() %></td>
                    <td><%= copy.getYear() %></td>
                    <% if (copy.isReserved()) { %>
                        <td>
                            <button type="submit" name="submit" class="btn btn-primary disabled">Reserved</button>
                        </td>
                    <% } else { %>
                        <% if (session.getAttribute("lister") != null) { %>
                            <td>
                                <form action="actions/reserveAction.jsp" method="post">
                                    <input type="hidden" name="isbn" value="<%=  book.getIsbn() %>">
                                    <input type="hidden" name="copyId" value="<%= copy.getId() %>">
                                    <button type="submit" name="submit" class="btn btn-primary">Reserve this Book</button>
                                </form>
                            </td>
                        <% } else { %>
                            <td>
                                <button type="submit" name="submit" class="btn btn-primary disabled">Login to reserve this book</button>
                            </td>   
                        <% } 
                    } %>
                    <td><%= copy.getLister() %></td>
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
