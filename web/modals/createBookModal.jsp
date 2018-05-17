<%-- 
    Document   : login
    Created on : 27/04/2018, 7:47:30 PM
    Author     : J-Mo
--%>
<div class="modal fade" id="createBookModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Book</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="actions/createBookAction.jsp" method="post">
                    <div class="form-group">
                        <input class="form-control" id="isbn" name="isbn" placeholder="ISBN" required="true" pattern="[0-9]{3}-[0-9]-[0-9]{2}-[0-9]{6}-[0-9]" title="Must be a valid ISBN">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="title" name="title" required="true" placeholder="Book title">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="description" name="description" required="true" placeholder="Book description">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="author" name="author" required="true" placeholder="Book author">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="category" name="category" required="true" placeholder="Book categories">
                        <small class="form-text text-muted">Enter all categories separated by a comma e.g. Fantasy, Fiction, Drama</small>
                    </div>
                    <br>
                    <button type="submit" name="submit" class="btn btn-primary">Add Book</button>
                </form>
            </div>
        </div>
    </div>
</div>
