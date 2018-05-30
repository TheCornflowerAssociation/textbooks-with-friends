/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

import cornflower.twf.model.Lister;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A Java EE filter class that intercepts incoming requests and filters them
 * based on session data on the following routes:
 * - /action/book/*
 * - /action/copy/*
 * 
 * @author J-Mo
 */
@WebFilter(urlPatterns = { "/action/book/*", "/action/copy/*" })
public class SessionFilter implements Filter {
    
    // Fields
    Lister lister;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {    
        // Convert the requests and responses to HTTP based objects
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        // Get the session object
        HttpSession session = request.getSession(true);
        
        try {
            // Get the lister
            lister = (Lister) session.getAttribute("lister");
            
            if (lister != null) {
                // Continue request path
                chain.doFilter(request, response);
            }
            else {
                // Reroute to failed session verification path
                throw new Exception();
            }
        }
        catch (Exception e) {
            // Redirect and message the user
            session.setAttribute("appMessage", new AppMessage("warning", "You must be logged in to perform this action"));
            response.sendRedirect("../form.jsp?form=login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}