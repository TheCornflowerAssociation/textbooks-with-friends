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
 *
 * @author J-Mo
 */
@WebFilter(urlPatterns = { "/action/book/*", "/action/copy/*" })
public class SessionFilter implements Filter {
    
    Lister lister;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        
        try {
            lister = (Lister) session.getAttribute("lister");
        }
        catch (Exception e) {
            session.setAttribute("appMessage", new AppMessage("warning", "You must be logged in to perform this action"));
            response.sendRedirect("../form.jsp?form=login");
        }

        if (lister != null) {
            chain.doFilter(request, response);
        } else {
            session.setAttribute("appMessage", new AppMessage("warning", "You must be logged in to perform this action"));
            response.sendRedirect("../form.jsp?form=login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}