<%-- 
    Document   : index
    Created on : 23/04/2018, 12:44:40 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String filter = request.getParameter("filter");
    Lister currentUser = (Lister) session.getAttribute("lister");
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Reservations reservations = ac.getReservations();
%>
<html>
    <%@include file="layouts/header.jsp" %>
    <body style="background-color: #f2f2f2">
        <%@include file="layouts/navbar.jsp" %>
        <div style="margin-left: 5%; margin-right: 5%;">
            <div class="row">
                <div class="col-md-3">
                    <br>
                    <%@include file="partials/bookListPartial.jsp" %>
                </div>
                <div class="col-md-9">
                    <%@include file="partials/bookPartial.jsp" %>
                </div>
            </div>
        </div>
        <%@include file="modals/loginModal.jsp" %>
        <%@include file="modals/reserveModal.jsp" %>
    </body>
</html>