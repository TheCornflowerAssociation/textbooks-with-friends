<%-- 
    Document   : loginAction
    Created on : 23/04/2018, 12:47:53 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>

<% 
    ActionController ac = new ActionController(application);
    Users users = ac.getUsers();
    
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    Lister lister = new Lister(username, email, password);
    users.addUser(lister);
    ac.commitUserData(users);
    
    session.setAttribute("lister", lister);
    
    session.setAttribute("appMessage", new AppMessage("success", "Account created"));
    response.sendRedirect("../index.jsp");
%>