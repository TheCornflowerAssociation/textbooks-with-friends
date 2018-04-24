<%-- 
    Document   : index
    Created on : 23/04/2018, 12:44:40 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    ActionController ac = new ActionController(application);
    
    Users users = ac.getUsers();
    Books books = ac.getBooks();
    
//    Lister lis = users.getListers().get(0);

//    users.addUser(new Lister("Dan", "dan@dan.dan", "password"));
//    users.removeUser(lis);
//    ac.commitUserData(users);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Listers (<%= users.getListers().size() %>)</h1>
        <% for (Lister l : users.getListers()) {
        
            %>
            <p><%= l.getUsername()%></p>
            <p><%= l.getEmail()%></p>
            <p><%= l.getPassword()%></p>
        <%
        
        } %>
        
        <h1>All Books (<%= books.getBooks().size() %>)</h1>
        <% for (Book b : books.getBooks()) {
        
            %>
            <p><%= b.getTitle() %></p>
            <p><%= b.getDescription() %></p>
        <%
        
        } %>
    </body>
</html>
