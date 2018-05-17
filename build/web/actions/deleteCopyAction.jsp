<%-- 
    Document   : deleteAction
    Created on : 23/04/2018, 12:48:41 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.model.BookCopy"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Books"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Reservation"%>
<%@page import="cornflower.twf.model.Reservations"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%
    ActionController ac = new ActionController(application);
    Reservations reservations = ac.getReservations();
    Books books = ac.getBooks();
    
    String isbn = request.getParameter("isbn");
    int copyId = Integer.parseInt(request.getParameter("copyId"));
    Lister lister = (Lister) session.getAttribute("lister");
    
    Book book = books.getBook(isbn);
    BookCopy copy = book.getBookCopy(copyId);
    if (copy.getLister().equals(lister.getEmail())) {
        // Remove the book
        book.removeBookCopy(copy);
        books.setBook(isbn, book);
        ac.commitBookData(books);

        // Remove any reservations for the book copy
        Reservation reservation = reservations.getReservation(isbn, copyId);
        if (reservation != null) {
            reservations.removeReservation(reservation);
        }
        ac.commitReservationData(reservations);
    }
    
    session.setAttribute("appMessage", new AppMessage("success", "Removed book copy #" + copyId + " for \"" + book.getTitle() + "\""));
    response.sendRedirect("../index.jsp");
%>