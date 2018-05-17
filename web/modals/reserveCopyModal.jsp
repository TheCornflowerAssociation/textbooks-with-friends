<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>
<div class="modal fade" id="reserveModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Reserve</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="actions/reserveAction.jsp" method="post">
                    <input id="reserveModalIsbn" type="hidden" name="isbn" value="">
                    <input id="reserveModalCopyId" type="hidden" name="copyId" value="">
                    <div class="form-group">
                        <input class="form-control" id="name" name="name" placeholder="Enter name">
                        <small id="emailHelp" class="form-text text-muted">Some error message</small>
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="email" name="email" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <small id="reserveModalMessage" class="form-text" style="color: red;"></small>
                    </div>
                    <br>
                    <button type="submit" name="submit" class="btn btn-primary">Reserve</button>
                </form>
            </div>
        </div>
    </div>
</div>
