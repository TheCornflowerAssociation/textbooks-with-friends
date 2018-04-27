<%-- 
    Document   : navbar
    Created on : 27/04/2018, 7:06:03 PM
    Author     : J-Mo
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Textbooks with Friends</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">My Listings</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">New Listing</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <%  Lister lister = (Lister) session.getAttribute("lister");
            if (lister != null) {
                System.out.print("found in session");
        %>
            <li class="nav-item">
                <a class="nav-link" href="#"><%= lister.getUsername() %></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="actions/logoutAction.jsp">Logout</a>
            </li>
        <%  } else { %>
            <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#loginModal">Login</button>
        <%  } %>
    </ul>
</nav>
<br>