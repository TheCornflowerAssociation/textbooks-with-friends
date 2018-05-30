<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page import="cornflower.twf.model.Reservation"%>
<% 
    // Check if the reservation has already been made
    Reservation reservation = ac.getReservations().getReservation(request.getParameter("isbn"), Integer.parseInt(request.getParameter("copyId")));
    if (reservation != null) {
        // Return the user to the homepage telling them that thier request could not be committed
        session.setAttribute("appMessage", new AppMessage("warning", "This book is already reserved for " + reservation.getName()));
        response.sendRedirect(request.getHeader("Referer"));
    }
%>
<form action="<%= request.getContextPath() %>/action/reservation" method="post">
    <input type="hidden" name="action" value="reserve"/>
    <input id="reserveModalIsbn" type="hidden" name="isbn" value="<%= request.getParameter("isbn") %>">
    <input id="reserveModalCopyId" type="hidden" name="copyId" value="<%= request.getParameter("copyId") %>">
    <div class="form-group">
        <input class="form-control" id="name" name="name" placeholder="Enter name">
    </div>
    <div class="form-group">
        <input class="form-control" id="email" name="email" placeholder="Enter email">
    </div>
    <br>
    <button type="submit" name="submit" class="btn btn-primary">Reserve</button>
</form>