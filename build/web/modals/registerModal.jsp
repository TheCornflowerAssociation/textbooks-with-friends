<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>

<%
    
%>
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Register</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="actions/registerAction.jsp" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" required="true">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Email" required="true" title="Must be a valid email address">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required="true" pattern=".{8,}" title="Password must be at least 8 characters long.">
                    </div>
                    <br>
                    <button type="submit" name="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
        </div>
    </div>
</div>
