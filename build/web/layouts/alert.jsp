<%-- 
    Document   : navbar
    Created on : 27/04/2018, 7:06:03 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<% 
    AppMessage appMessage = (AppMessage) session.getAttribute("appMessage");
    if (appMessage != null) {
        session.setAttribute("appMessage", null);
        String alertMessage = appMessage.getMessage();
        String alertType = appMessage.getType();
%>
    <div class="container">

        <div class="alert alert-<%= alertType %>" role="alert">
            <%= alertMessage %>
        </div>
    </div>
    <br>
<% } %>