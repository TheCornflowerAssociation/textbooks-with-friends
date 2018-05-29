<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : books.xsl
    Created on : 27 May 2018, 8:17 PM
    Author     : rubrixs
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    
    
    <xsl:template match="book">
        <li class="list-group-item">
            <xsl:element name="a">
                <xsl:attribute name="href">
                    <xsl:text disable-output-escaping="yes"><![CDATA[index.jsp?<%= filter != null ? "filter=" + filter : "" %>&isbn=]]></xsl:text>
                    <xsl:value-of select="isbn"/>
                </xsl:attribute>
                <xsl:value-of select="title"/>
            </xsl:element>
            <p>by <xsl:value-of select="author"/></p>
        </li> 
    </xsl:template>

</xsl:stylesheet>
