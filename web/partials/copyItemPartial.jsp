<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.model.Reservation"%>
<tr>
    <th><%= copy.getId() %></th>
    <td><%= copy.getCondition() %></td>
    <td><%= copy.getEdition() %></td>
    <td><%= copy.getPublisher() %></td>
    <td><%= copy.getYear() %></td>
    <% Reservation reservation = reservations.getReservation(book.getIsbn(), copy.getId()); %>
    <% if (reservation != null) { %>
        <td>
            <button type="submit" name="submit" class="btn btn-primary disabled">Reserved <%= currentUser != null ? " by " + reservation.getName() : "" %></button>
        </td>
    <% } else { %>
        <td>
            <a class="btn btn-primary" href="form.jsp?form=reserve&isbn=<%= book.getIsbn() %>&copyId=<%= copy.getId() %>">Reserve this Book</a>
        </td>
    <% } %>
    <td><%= copy.getLister() %></td>
    <% if (currentUser != null && currentUser.getEmail().equals(copy.getLister())) { %>
        <td>
            <form action="<%= request.getContextPath() %>/action/copy" method="post">
                <input type="hidden" name="action" value="delete"/>
                <input type="hidden" name="isbn" value="<%= book.getIsbn() %>">
                <input type="hidden" name="copyId" value="<%= copy.getId() %>">
                <button type="submit" name="submit" class="btn btn-danger">Delete</button>
            </form>
        </td>
    <% } else if (currentUser != null) { %>
        <td>
            <p>You are not lister</p>
        </td>
    <% } %>
</tr>