<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<% 
    // Separate the categories by comma
    String categories[] = book.getCategory().trim().split(",");
    
    // Display each of them as a badge
    for (String category : categories) {
%>
    <span class="badge badge-primary"><%= category %></span>
<% } %>
