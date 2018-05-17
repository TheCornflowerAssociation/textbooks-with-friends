<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>

<%
    
%>
<div class="modal fade" id="createCopyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Copy</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="actions/createCopyAction.jsp" method="post">
                    <input id="createCopyModalIsbn" type="hidden" name="isbn" value="">
                    <div class="form-group">
                        <select class="form-control" id="condition" name="condition">
                            <option value="" disabled selected>Copy condition</option>
                            <option>New</option>
                            <option>Good</option>
                            <option>Fair</option>
                            <option>Poor</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="edition" name="edition" placeholder="Copy edition">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="year" name="year" placeholder="Copy year">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="publisher" name="publisher" placeholder="Copy publisher">
                    </div>
                    <div class="form-group">
                        <small id="createCopyModalMessage" class="form-text" style="color: red;"></small>
                    </div>
                    <br>
                    <button type="submit" name="submit" class="btn btn-primary">Add Copy</button>
                </form>
            </div>
        </div>
    </div>
</div>
