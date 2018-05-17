<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<tr>
    <th><%= copy.getId() %></th>
    <td><%= copy.getCondition() %></td>
    <td><%= copy.getEdition() %></td>
    <td><%= copy.getPublisher() %></td>
    <td><%= copy.getYear() %></td>
    <% if (reservations.checkReserved(book.getIsbn(), copy.getId())) { %>
        <td>
            <button type="submit" name="submit" class="btn btn-primary disabled">Reserved</button>
        </td>
    <% } else { %>
        <td>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#reserveModal" onclick='setReserveModalValues(<%= '\"' + book.getIsbn() + '\"' %>, <%= copy.getId() %>);'>Reserve this Book</button>
        </td>
    <% } %>
    <td><%= copy.getLister() %></td>
    <% if (currentUser != null && currentUser.getEmail().equals(copy.getLister())) { %>
        <td>
            <form action="actions/deleteCopyAction.jsp" method="post">
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