<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>

<form action="<%= request.getContextPath() %>/action/user" method="post">
    <div class="form-group">
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Email">
    </div>
    <div class="form-group">
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
    <br>
    <button type="submit" name="submit" class="btn btn-primary">Register</button>
</form>