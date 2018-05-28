package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cornflower.twf.model.Reservations;
import cornflower.twf.model.Book;
import cornflower.twf.model.Books;
import cornflower.twf.model.Lister;
import cornflower.twf.model.Users;
import cornflower.twf.utils.ActionController;
import cornflower.twf.model.Lister;
import cornflower.twf.utils.AppMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import cornflower.twf.model.BookCopy;
import cornflower.twf.model.Reservation;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/layouts/header.jsp");
    _jspx_dependants.add("/layouts/navbar.jsp");
    _jspx_dependants.add("/layouts/alert.jsp");
    _jspx_dependants.add("/partials/bookListPartial.jsp");
    _jspx_dependants.add("/partials/categoriesPartial.jsp");
    _jspx_dependants.add("/partials/bookPartial.jsp");
    _jspx_dependants.add("/partials/copyItemPartial.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
 
    String filter = request.getParameter("filter");
    Lister currentUser = (Lister) session.getAttribute("lister");
    ActionController ac = new ActionController(application);
    Books books = ac.getBooks();
    Reservations reservations = ac.getReservations();

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("To change this license header, choose License Headers in Project Properties.\r\n");
      out.write("To change this template file, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" crossorigin=\"anonymous\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.10/css/all.css\" crossorigin=\"anonymous\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Textbooks with Friends</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("    <body style=\"background-color: #f2f2f2\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"index.jsp\"><i class=\"fas fa-bookmark\"></i> Textbooks with Friends</a>\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"index.jsp\">All Listings</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"index.jsp?filter=unreserved\">Unreserved Listings</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        ");

            if (currentUser != null) {
        
      out.write("\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"index.jsp?filter=myListings\">My Listings</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"form.jsp?form=add_book\">Add Book</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("        ");

            if (currentUser != null) {
        
      out.write("\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">");
      out.print( currentUser.getUsername() );
      out.write("</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item active\">\r\n");
      out.write("                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/action/session\" method=\"delete\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"delete\"/>\r\n");
      out.write("                    <button type=\"submit\" name=\"submit\" class=\"btn btn-danger\">Logout</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </li>\r\n");
      out.write("        ");
  } else { 
      out.write("\r\n");
      out.write("            <a class=\"btn btn-dark\" href=\"form.jsp?form=login\">Login</a>\r\n");
      out.write("            <a class=\"btn btn-dark\" href=\"form.jsp?form=register\">Register</a>\r\n");
      out.write("        ");
  } 
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<br>");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
 
    AppMessage appMessage = (AppMessage) session.getAttribute("appMessage");
    if (appMessage != null) {
        session.setAttribute("appMessage", null);
        String alertMessage = appMessage.getMessage();
        String alertType = appMessage.getType();

      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"alert alert-");
      out.print( alertType );
      out.write("\" role=\"alert\">\r\n");
      out.write("            ");
      out.print( alertMessage );
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <br>\r\n");
 } 
      out.write("\r\n");
      out.write("        <div style=\"margin-left: 5%; margin-right: 5%;\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-3\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");
 
    ArrayList<Book> booksList;

      out.write("\r\n");
      out.write("<h2 class=\"text-center\">\r\n");
      out.write("    ");
 if (currentUser != null && filter != null && filter.equals("myListings")) {
        booksList = books.getBooksByLister(currentUser.getEmail());
    
      out.write("\r\n");
      out.write("        <span>My Listings </span>\r\n");
      out.write("    ");
 } else if (filter != null && filter.equals("unreserved")) {
        booksList = books.getUnreservedBooks(reservations);
    
      out.write("\r\n");
      out.write("        <span>Unreserved Books </span>\r\n");
      out.write("    ");
 } else {
        booksList = books.getBooks();
    
      out.write("\r\n");
      out.write("        <span>All Books </span>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</h2>\r\n");
      out.write("<br>\r\n");
      out.write("<div class=\"card\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("        <ul class=\"list-group list-group-flush\">\r\n");
      out.write("            ");
 for (Book book : booksList) { 
      out.write("\r\n");
      out.write("                <li class=\"list-group-item\">\r\n");
      out.write("                    <a href=\"index.jsp?");
      out.print( filter != null ? "filter=" + filter : "" );
      out.write("&isbn=");
      out.print( book.getIsbn() );
      out.write("\">\r\n");
      out.write("                        <h5>");
      out.print( book.getTitle() );
      out.write("</h5>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <p>by ");
      out.print( book.getAuthor() );
      out.write("</p>\r\n");
      out.write("                    <p>");
      out.write('\r');
      out.write('\n');
 
    String categories[] = book.getCategory().trim().split(",");
                
    for (String category : categories) {

      out.write("\r\n");
      out.write("    <span class=\"badge badge-primary\">");
      out.print( category );
      out.write("</span>\r\n");
 } 
      out.write('\r');
      out.write('\n');
      out.write("</p>\r\n");
      out.write("                </li>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-9\">\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
    Book book = books.getBook(request.getParameter("isbn"));
    
    if (book != null) {
        
        ArrayList<BookCopy> copies;
        
        if (filter != null && filter.equals("myListings")) {
            copies = book.getCopiesByLister(currentUser.getEmail());
        }
        else if (filter != null && filter.equals("unreserved")) {
            copies = book.getUnreservedCopies(reservations);
        }
        else {
            copies = book.getBookCopies();
        }

      out.write("\r\n");
      out.write("<div class=\"card\">\r\n");
      out.write("    <h4 class=\"card-header\">");
      out.print( book.getTitle() );
      out.write("</h4>\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("        <h5 class=\"card-title\">\r\n");
      out.write("            by ");
      out.print( book.getAuthor() );
      out.write(" | \r\n");
      out.write("            ");
      out.write('\r');
      out.write('\n');
 
    String categories[] = book.getCategory().trim().split(",");
                
    for (String category : categories) {

      out.write("\r\n");
      out.write("    <span class=\"badge badge-primary\">");
      out.print( category );
      out.write("</span>\r\n");
 } 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("        </h5>\r\n");
      out.write("        <p class=\"card-text\"><b>ISBN:</b> ");
      out.print( book.getIsbn() );
      out.write("</p>\r\n");
      out.write("        <p class=\"card-text\"><b>Description:</b> ");
      out.print( book.getDescription() );
      out.write("</p>\r\n");
      out.write("        <br>\r\n");
      out.write("        <table class=\"table\">\r\n");
      out.write("            <thead class=\"thead-dark\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th scope=\"col\">ID</th>\r\n");
      out.write("                    <th scope=\"col\">Condition</th>\r\n");
      out.write("                    <th scope=\"col\">Edition</th>\r\n");
      out.write("                    <th scope=\"col\">Publisher</th>\r\n");
      out.write("                    <th scope=\"col\">Year</th>\r\n");
      out.write("                    <th scope=\"col\">Status</th>\r\n");
      out.write("                    <th scope=\"col\">Lister</th>\r\n");
      out.write("                    ");
 if (currentUser != null) { 
      out.write("\r\n");
      out.write("                        <th scope=\"col\">Options</th>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                ");

                    for (BookCopy copy : copies) {
                
      out.write("\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("    <th>");
      out.print( copy.getId() );
      out.write("</th>\r\n");
      out.write("    <td>");
      out.print( copy.getCondition() );
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print( copy.getEdition() );
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print( copy.getPublisher() );
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print( copy.getYear() );
      out.write("</td>\r\n");
      out.write("    ");
 Reservation reservation = reservations.getReservation(book.getIsbn(), copy.getId()); 
      out.write("\r\n");
      out.write("    ");
 if (reservation != null) { 
      out.write("\r\n");
      out.write("        <td>\r\n");
      out.write("            <button type=\"submit\" name=\"submit\" class=\"btn btn-primary disabled\">Reserved ");
      out.print( currentUser != null ? " by " + reservation.getName() : "" );
      out.write("</button>\r\n");
      out.write("        </td>\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("        <td>\r\n");
      out.write("            <a class=\"btn btn-primary\" href=\"form.jsp?form=reserve&isbn=");
      out.print( book.getIsbn() );
      out.write("&copyId=");
      out.print( copy.getId() );
      out.write("\">Reserve this Book</a>\r\n");
      out.write("        </td>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    <td>");
      out.print( copy.getLister() );
      out.write("</td>\r\n");
      out.write("    ");
 if (currentUser != null && currentUser.getEmail().equals(copy.getLister())) { 
      out.write("\r\n");
      out.write("        <td>\r\n");
      out.write("            <form action=\"");
      out.print( request.getContextPath() );
      out.write("/action/copy\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"delete\"/>\r\n");
      out.write("                <input type=\"hidden\" name=\"isbn\" value=\"");
      out.print( book.getIsbn() );
      out.write("\">\r\n");
      out.write("                <input type=\"hidden\" name=\"copyId\" value=\"");
      out.print( copy.getId() );
      out.write("\">\r\n");
      out.write("                <button type=\"submit\" name=\"submit\" class=\"btn btn-danger\">Delete</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </td>\r\n");
      out.write("    ");
 } else if (currentUser != null) { 
      out.write("\r\n");
      out.write("        <td>\r\n");
      out.write("            <p>You are not lister</p>\r\n");
      out.write("        </td>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</tr>");
      out.write("\r\n");
      out.write("                ");

                    }

                    if (copies.size() <= 0) {
                
      out.write("\r\n");
      out.write("                    <tr><td><p>No copies to display</p></td></tr>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        ");
 if (currentUser != null) { 
      out.write("\r\n");
      out.write("        <a class=\"btn btn-primary float-right\" href=\"form.jsp?form=add_copy&isbn=");
      out.print( book.getIsbn() );
      out.write("\">Add Copy</a>\r\n");
      out.write("            ");
 if (copies.size() <= 0) { 
      out.write("\r\n");
      out.write("                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/action/book\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"delete\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"isbn\" value=\"");
      out.print( book.getIsbn() );
      out.write("\">\r\n");
      out.write("                    <button type=\"submit\" name=\"submit\" class=\"btn btn-danger\">Remove Book</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            ");
 }
           } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");

    } else {

      out.write("\r\n");
      out.write("<div class=\"card\">\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("        <h4 class=\"card-title text-center\">Select a book to view from the list</h4>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
 } 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
