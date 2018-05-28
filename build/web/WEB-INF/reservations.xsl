<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : reservations.xsl
    Created on : 27 May 2018, 8:18 PM
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
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    h2{
                        text-align:center;
                    }
                    
                    table{
                        width: 60%;
                    }
                </style>
            </head>
            <body>
                <h2>Reservations</h2>
                <xsl:apply-templates/> 
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="reservations">
        <table border = "1" align ="center">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>CopyID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
            </thead>
        
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    
    <xsl:template match="reservation">
        <tr>
            <td>
                <xsl:value-of select="isbn" />
            </td>
            <td>
                <xsl:value-of select="copyId" />
            </td>  
            <td>
                <xsl:value-of select="name" />
            </td>
            <td>
                <xsl:value-of select="email" />
            </td>              
        </tr>  
    </xsl:template>

</xsl:stylesheet>
