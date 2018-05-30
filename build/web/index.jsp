<%-- 
    Document   : index
    Created on : 23/04/2018, 12:44:40 PM
    Author     : J-Mo
--%>

<%@page import="cornflower.twf.utils.XmlFetcher"%>
<%@page import="java.io.StringWriter"%>
<%@page import="javax.xml.bind.Marshaller"%>
<%@page import="javax.xml.bind.JAXBContext"%>
<%@page import="cornflower.twf.model.Book"%>
<%@page import="cornflower.twf.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layouts/baseData.jsp" %>
<html>
    <!--Import JSTL components-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
    
    <!--Get the HTML header-->
    <%@include file="layouts/header.jsp" %>
    <body style="background-color: #f2f2f2">
        
        <!--Display the navbar with the alert module below-->
        <%@include file="layouts/navbar.jsp" %>
        <%@include file="layouts/alert.jsp" %>
        <div style="margin-left: 5%; margin-right: 5%;">
            <div class="row">
                <div class="col-md-3">
                    <br>
                    <!--Show the books list-->
                    <%@include file="partials/bookListPartial.jsp" %>
                </div>
                <div class="col-md-9">
                    <!--Show the currently selected book-->
                    <%@include file="partials/bookPartial.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>