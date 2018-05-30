/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.action;

import cornflower.twf.model.Reservation;
import cornflower.twf.model.Reservations;
import cornflower.twf.utils.ActionController;
import cornflower.twf.utils.AppMessage;
import cornflower.twf.utils.Validator;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet class for the reservation object that services the /action/reservation route.
 * 
 * @author J-Mo
 */
@WebServlet("/action/reservation")
public class ReservationServlet extends javax.servlet.http.HttpServlet {
    
    // Fields
    ActionController ac;
    HttpSession session;
    
    /**
     * A helper method that sets up the fields before jumping into the request
     * action. Also reroutes in the case of an exception.
     * 
     * @param request - the request object
     * @param response - the response object
     * @throws IOException - excepts null referrer status 
     */
    private void setFields(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ac = new ActionController(request.getServletContext());
            session = request.getSession();
        } catch (Exception ex) {
            session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the fields up
        setFields(request, response);
        
        // Get reservations
        Reservations reservations = ac.getReservations();
        
        // Create a validator
        Validator v = new Validator();

        // Get the fields
        String isbn = request.getParameter("isbn");
        int copyId = Integer.parseInt(request.getParameter("copyId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Perform field validations
        boolean validationsFail = false;

        AppMessage nameError = v.validText(name, "name");
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

        if (validationsFail) {
            response.sendRedirect(request.getHeader("Referer"));
        }
        else {
            Reservation reservation = new Reservation(isbn, copyId, name, email);

            reservations.addOrSetReservation(isbn, copyId, reservation);
            try {
                ac.commitReservationData(reservations);
            } catch (Exception ex) {
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect(request.getHeader("Referer"));
            }
            session.setAttribute("appMessage", new AppMessage("success", "Successfully reserved book"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}