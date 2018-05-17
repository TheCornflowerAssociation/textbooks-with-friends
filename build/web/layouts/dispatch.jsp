<%-- 
    Document   : navbar
    Created on : 27/04/2018, 7:06:03 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.DispatchAction"%>
<script>
    function openModalWithMessage(modalId, message) {
        document.getElementById(modalId + "Message").innerHTML = message;
        $('#' + modalId).modal('show')
    }
</script>
<% 
    // Use this line of code to open any modal with error text
    session.setAttribute("dispatchAction", new DispatchAction("registerModal", "This is some error text"));
    
    
    DispatchAction dispatchAction = (DispatchAction) session.getAttribute("dispatchAction");
    if (dispatchAction != null) {
        session.setAttribute("dispatchAction", null);
%>
<script>
    openModalWithMessage("<%= dispatchAction.getModal() %>", "<%= dispatchAction.getMessage() %>");
</script> 
<%
    }
%>