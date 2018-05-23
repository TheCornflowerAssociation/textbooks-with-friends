<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>
<form action="actions/reserveAction.jsp" method="post">
    <input id="reserveModalIsbn" type="hidden" name="isbn" value="<%= request.getParameter("isbn") %>">
    <input id="reserveModalCopyId" type="hidden" name="copyId" value="<%= request.getParameter("copyId") %>">
    <div class="form-group">
        <input class="form-control" id="name" name="name" placeholder="Enter name">
    </div>
    <div class="form-group">
        <input class="form-control" id="email" name="email" placeholder="Enter email">
    </div>
    <br>
    <button type="submit" name="submit" class="btn btn-primary">Reserve</button>
</form>