<%-- 
    Document   : form
    Created on : 23/05/2018, 2:31:34 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<% 
    String filter = request.getParameter("filter");
    Lister currentUser = (Lister) session.getAttribute("lister");
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Reservations reservations = ac.getReservations();
    
    String formTitle = request.getParameter("form").replaceAll("_", " ");
%>
<html>
    <%@include file="layouts/header.jsp" %>
    <body style="background-color: #f2f2f2">
        <%@include file="layouts/navbar.jsp" %>
        <%@include file="layouts/alert.jsp" %>
        <div style="margin-left: 5%; margin-right: 5%;">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class="text-center" style="text-transform: capitalize;"><%= formTitle %></h1>
                    <br>
                    <% if (formTitle.equalsIgnoreCase("login")) { %>
                        <%@include file="forms/login.jsp" %>
                    <% } else if (formTitle.equalsIgnoreCase("register")) { %>
                        <%@include file="forms/register.jsp" %>
                    <% } else if (formTitle.equalsIgnoreCase("reserve")) { %>
                        <%@include file="forms/reserve.jsp" %>
                    <% } else if (formTitle.equalsIgnoreCase("add book")) { %>
                        <%@include file="forms/createBook.jsp" %>
                    <% } else if (formTitle.equalsIgnoreCase("add copy")) { %>
                        <%@include file="forms/createCopy.jsp" %>
                    <% } %>
                </div>
            </div>
        </div>
    </body>
</html>