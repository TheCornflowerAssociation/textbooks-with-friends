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
 *
 * @author J-Mo
 */
@WebServlet("/action/session")
public class SessionServlet extends javax.servlet.http.HttpServlet {
    
    // Fields
    ActionController ac;
    HttpSession session;
    
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
        setFields(request);

        Users users = ac.getUsers();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Lister lister = users.login(email, password);

        if (lister != null) {
            session.setAttribute("lister", lister);
            session.setAttribute("appMessage", new AppMessage("primary", "Logged in"));
            response.sendRedirect("../index.jsp");
        }
        else {
            // Deal with bad login info
            session.setAttribute("appMessage", new AppMessage("danger", "Could not log you in, incorrect email or password"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            setFields(request);
            session.setAttribute("lister", null);
            session.setAttribute("appMessage", new AppMessage("primary", "Logged out"));
            response.sendRedirect("../index.jsp");
        }
        else {
            session.setAttribute("appMessage", new AppMessage("warning", "Invalid form action"));
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
