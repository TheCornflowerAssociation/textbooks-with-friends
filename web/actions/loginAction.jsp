<%-- 
    Document   : loginAction
    Created on : 23/04/2018, 12:47:53 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.ActionController"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>

<% 
    ActionController ac = new ActionController(application);
    Users users = ac.getUsers();
    
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    Lister lister = users.login(email, password);
    System.out.print(lister);
    
    if (lister != null) {
        System.out.print("lister not null");
        session.setAttribute("lister", lister);
        response.sendRedirect("../index.jsp");
    }
    else {
        System.out.print("lister null");
        response.sendRedirect("../index.jsp");
    }
%>