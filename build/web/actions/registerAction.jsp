<%-- 
    Document   : loginAction
    Created on : 23/04/2018, 12:47:53 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.Validator"%>
<%@page import="cornflower.twf.utils.AppMessage"%>
<%@page import="cornflower.twf.utils.ActionController"%>
<%@page import="cornflower.twf.model.Lister"%>
<%@page import="cornflower.twf.model.Users"%>

<%
    ActionController ac = new ActionController(application);
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

    // ----------
    if (validationsFail) {
        response.sendRedirect(request.getHeader("Referer"));
    } else {
        Lister lister = new Lister(username, email, password);
        users.addUser(lister);
        ac.commitUserData(users);

        session.setAttribute("lister", lister);
        session.setAttribute("appMessage", new AppMessage("success", "Account created"));
        response.sendRedirect("../index.jsp");
    }
%>