<%-- 
    Document   : reserveAction
    Created on : 23/04/2018, 12:47:23 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.model.Reservation"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Reservations reservations = ac.getReservations();
    
    
    String isbn = request.getParameter("isbn");
    
    
    int copyId = Integer.parseInt(request.getParameter("copyId"));
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    Reservation reservation = new Reservation(isbn, copyId, name, email);
    
    reservations.addOrSetReservation(isbn, copyId, reservation);
    ac.commitReservationData(reservations);
    
    session.setAttribute("appMessage", new AppMessage("success", "Successfully reserved book"));
    response.sendRedirect("../index.jsp");
%>
