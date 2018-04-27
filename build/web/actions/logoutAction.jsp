<%-- 
    Document   : logout
    Created on : 27/04/2018, 8:46:59 PM
    Author     : J-Mo
--%>

<%
    session.setAttribute("lister", null);
    response.sendRedirect("../index.jsp");
%>
