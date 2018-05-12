<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<% 
    String categories[] = book.getCategory().trim().split(",");
                
    for (String category : categories) {
%>
    <span class="badge badge-primary"><%= category %></span>
<% } %>
