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
 *
 * @author J-Mo
 */
@WebServlet("/action/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    
    // Fields
    ActionController ac;
    HttpSession session;
    
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
        setFields(request, response);
        
        Users users = ac.getUsers();
        Validator v = new Validator();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validation
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
            response.sendRedirect(request.getHeader("Referer"));
        } else {
            Lister lister = new Lister(username, email, password);
            users.addUser(lister);
            try {
                ac.commitUserData(users);
            } catch (Exception ex) {
                session.setAttribute("appMessage", new AppMessage("danger", "Something went wrong while committing your data"));
                response.sendRedirect("../index.jsp");
            }

            session.setAttribute("lister", lister);
            session.setAttribute("appMessage", new AppMessage("success", "Account created"));
            response.sendRedirect("../index.jsp");
        }
    }
}