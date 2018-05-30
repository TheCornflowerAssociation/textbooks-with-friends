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
import cornflower.twf.utils.Validator;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet class for the user object that services the /action/user route.
 * 
 * @author J-Mo
 */
@WebServlet("/action/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    
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
            response.sendRedirect("../index.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the fields
        setFields(request, response);
        
        // Get the users object
        Users users = ac.getUsers();
        
        // Create a new validator
        Validator v = new Validator();

        // Get the fields
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform validations
        boolean validationsFail = false;

        AppMessage usernameError = v.notEmpty(username);
        if (usernameError != null) {
            session.setAttribute("appMessage", usernameError);
            validationsFail = true;
        }

        AppMessage emailError = v.validEmail(email);
        if (emailError != null) {
            session.setAttribute("appMessage", emailError);
            validationsFail = true;
        }

        AppMessage passwordError = v.notEmpty(password);
        if (passwordError != null) {
            session.setAttribute("appMessage", passwordError);
            validationsFail = true;
        }

        if (username.equals("") || email.equals("") || password.equals("")) {
            session.setAttribute("appMessage", new AppMessage("danger", "Please fill in all required fields."));
            validationsFail = true;
        }

        if (validationsFail) {
            // Return with the validation failure message
            response.sendRedirect(request.getHeader("Referer"));
        } 
        else {
            // Create the new user
            Lister lister = new Lister(username, email, password);
            users.addUser(lister);
            try {
                // Commit the data
                ac.commitUserData(users);
            } catch (Exception ex) {
                // Return with a failure message
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect("../index.jsp");
            }

            // Set the new user in the session
            session.setAttribute("lister", lister);
            
            // Redirect to home with a success message
            session.setAttribute("appMessage", new AppMessage("success", "Account created"));
            response.sendRedirect("../index.jsp");
        }
    }
}