<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<div class="card">
    <div class="card-body">
        <ul class="list-group list-group-flush">
            <% for (Book b : books.getBooks()) { %>
                <li class="list-group-item">
                    <a href="#"><h3><%= b.getTitle() %></h3></a>
                    <p><%= b.getDescription() %></p>
                </li>
            <% } %>
        </ul>
    </div>
</div>
