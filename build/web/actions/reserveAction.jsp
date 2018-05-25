<%-- 
    Document   : reserveAction
    Created on : 23/04/2018, 12:47:23 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.Validator"%>
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
    Validator v = new Validator();
    
    
    String isbn = request.getParameter("isbn");
    
    
    int copyId = Integer.parseInt(request.getParameter("copyId"));
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    // Validation
    boolean validationsFail = false;

    AppMessage nameError = v.validText(name);
    if (nameError != null) {
        session.setAttribute("appMessage", nameError);
        validationsFail = true;
    }

    AppMessage emailError = v.validEmail(email);
    if (emailError != null) {
        session.setAttribute("appMessage", emailError);
        validationsFail = true;
    }
    
    if (name.equals("") || email.equals("")) {
        session.setAttribute("appMessage", new AppMessage("danger", "Please fill in all required fields."));
        validationsFail = true;
    }

    // ----------
    
    if (validationsFail) {
        response.sendRedirect(request.getHeader("Referer"));
    }
    else {
        Reservation reservation = new Reservation(isbn, copyId, name, email);

        reservations.addOrSetReservation(isbn, copyId, reservation);
        ac.commitReservationData(reservations);
        session.setAttribute("appMessage", new AppMessage("success", "Successfully reserved book"));
        response.sendRedirect("../index.jsp");
    }
%>
