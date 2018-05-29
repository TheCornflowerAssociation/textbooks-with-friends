<%-- 
    Document   : bookListPartial
    Created on : 27/04/2018, 6:56:00 PM
    Author     : J-Mo
--%>
<%@page import="cornflower.twf.utils.XmlFetcher"%>
<%@page import="java.io.StringWriter"%>
<%
    StringWriter copyXmlText = XmlFetcher.getCopiesList(copies, book.getIsbn());
%>

<c:set var = "copyXml">
    <%= copyXmlText %>
</c:set>

<c:import url="/WEB-INF/bookCopies.xsl" var="xslt"/>
<x:transform xml="${copyXml}" xslt="${xslt}"/>