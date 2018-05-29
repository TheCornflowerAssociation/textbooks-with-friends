<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.XmlFetcher"%>
<%@page import="java.io.StringWriter"%>
<%
    StringWriter xmlString = XmlFetcher.getCopiesList(copies, book.getIsbn());
%>

<c:set var = "xmltext">
    <%= xmlString %>
</c:set>

<c:import url="/WEB-INF/bookCopies.xsl" var="xslt"/>
<x:transform xml="${xmltext}" xslt="${xslt}"/>