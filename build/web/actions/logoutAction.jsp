<%-- 
    Document   : logout
    Created on : 27/04/2018, 8:46:59 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%
    session.setAttribute("lister", null);
    session.setAttribute("appMessage", new AppMessage("primary", "Logged out"));
    response.sendRedirect("../index.jsp");
%>
