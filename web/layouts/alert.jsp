<%-- 
    Document   : navbar
    Created on : 27/04/2018, 7:06:03 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<% 
    // Get the app message from the session and display it
    AppMessage appMessage = (AppMessage) session.getAttribute("appMessage");
    if (appMessage != null) {
        // Remove it from the session
        session.setAttribute("appMessage", null);
%>
    <div class="container">

        <div class="alert alert-<%= appMessage.getType() %>" role="alert">
            <%= appMessage.getMessage() %>
        </div>
    </div>
    <br>
<% } %>