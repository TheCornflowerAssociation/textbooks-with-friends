<%-- 
    Document   : baseData
    Created on : 30/05/2018, 2:27:56 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page import="cornflower.twf.model.Lister"%>
<% 
    // Get the current filter (if there is one)
    String filter = request.getParameter("filter");
    
    // Get the logged-in user (if there is one)
    Lister currentUser = (Lister) session.getAttribute("lister");
    
    // Fetch the book and reservation objects from persistence
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Reservations reservations = ac.getReservations();
%>
