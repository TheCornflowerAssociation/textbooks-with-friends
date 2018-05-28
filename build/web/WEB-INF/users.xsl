<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : users.xsl
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
                        text-align:center;
                    
                    }
                </style>
            </head>
            <body>
                <h2>Users</h2>
                
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="users">
        <table border = "1" align ="center">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Username</th>
                </tr>
            </thead>
            
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
   
    <xsl:template match="lister">
        <tr>
            <td>
                <xsl:value-of select="email" />              
            </td>
            <td>
                <xsl:value-of select="username" />
            </td> 
        </tr>
        
    </xsl:template>

</xsl:stylesheet>
