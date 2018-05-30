/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.action;
import cornflower.twf.model.Lister;
import cornflower.twf.model.Users;
import cornflower.twf.utils.ActionController;
import cornflower.twf.utils.AppMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet class for the session object that services the /action/session route.
 * 
 * @author J-Mo
 */
@WebServlet("/action/session")
public class SessionServlet extends javax.servlet.http.HttpServlet {
    
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
    private void setFields(HttpServletRequest request) {
        try {
            ac = new ActionController(request.getServletContext());
            session = request.getSession();
        } catch (Exception ex) {
            Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the request fields
        setFields(request);
        
        // Get the users object
        Users users = ac.getUsers();

        // Get the parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Attempt to get the user object
        Lister lister = users.login(email, password);

        if (lister != null) {
            // Add the user to the session
            session.setAttribute("lister", lister);
            // Return to home with a success message
            session.setAttribute("appMessage", new AppMessage("primary", "Logged in"));
            response.sendRedirect("../index.jsp");
        }
        else {
            // Return with a failure message
            session.setAttribute("appMessage", new AppMessage("danger", "Could not log you in, incorrect email or password"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Check for a delete method
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            // Set the fields
            setFields(request);
            // Remove the user from the session
            session.setAttribute("lister", null);
            // Return with a success message
            session.setAttribute("appMessage", new AppMessage("primary", "Logged out"));
            response.sendRedirect("../index.jsp");
        }
        else {
            // Return with a failure message
            session.setAttribute("appMessage", new AppMessage("warning", "Invalid form action"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
