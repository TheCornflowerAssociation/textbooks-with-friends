<%-- 
    Document   : index
    Created on : 23/04/2018, 12:44:40 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    ActionController ac = new ActionController(application);
    
    Users users = ac.getUsers();
    
    users.addUser(new Lister("Toblo", "tob@lo.com", "password"));
    ac.saveUsers(users);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= users.getListers() %></h1>
        <% for (Lister l : users.getListers()) {
        
            %>
            <p><%= l.getUsername()%></p>
            <p><%= l.getEmail()%></p>
            <p><%= l.getPassword()%></p>
        <%
        
        } %>
    </body>
</html>
