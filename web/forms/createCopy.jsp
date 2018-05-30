<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.model.Book"%>
<%
    // Get the book to run the form for via its ISBN
    String isbn = request.getParameter("isbn");
    Book book = books.getBook(isbn);
%>
<h3 class="text-center">for <%= book.getTitle() %></h3>
<br>
<form action="<%= request.getContextPath() %>/action/copy" method="post">
    <input id="createCopyModalIsbn" type="hidden" name="isbn" value="<%= isbn %>">
    <div class="form-group">
        <select class="form-control" id="condition" name="condition">
            <option value="" disabled selected>Copy condition</option>
            <option>New</option>
            <option>Good</option>
            <option>Fair</option>
            <option>Poor</option>
        </select>
    </div>
    <div class="form-group">
        <input class="form-control" id="edition" name="edition" placeholder="Copy edition">
    </div>
    <div class="form-group">
        <input class="form-control" id="year" name="year" placeholder="Copy year">
    </div>
    <div class="form-group">
        <input class="form-control" id="publisher" name="publisher" placeholder="Copy publisher">
    </div>
    <div class="form-group">
        <small id="createCopyModalMessage" class="form-text" style="color: red;"></small>
    </div>
    <br>
    <button type="submit" name="submit" class="btn btn-primary">Add Copy</button>
</form>