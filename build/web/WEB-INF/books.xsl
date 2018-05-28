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
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    h2{
                        text-align:center;
                    }  
                </style>
            </head>
            <body>
                <h2>Books</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="books">
        <table border = "1" align ="center">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>BookCopy</th>
                </tr>
            </thead>
            
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    
    <xsl:template match="book">
        <tr>
            <td>
                <xsl:value-of select="isbn" />
            </td>
            <td>
                <xsl:value-of select="title" />
            </td>  
            <td>
                <xsl:value-of select="author" />
            </td>
            <td>
                <xsl:value-of select="description" />
            </td>
            <td>
                <xsl:value-of select="category" />
            </td>  
            <td>
                <xsl:value-of select="bookCopy" />
            </td>                      
        </tr>   
    </xsl:template>
    
    <xsl:template match="bookCopy">
        <tr>
            <td>
                <xsl:value-of select="id" />
            </td>
            <td>
                <xsl:value-of select="condition" />
            </td>  
            <td>
                <xsl:value-of select="lister" />
            </td>
            <td>
                <xsl:value-of select="edition" />
            </td>
            <td>
                <xsl:value-of select="publisher" />
            </td> 
            <td>
                <xsl:value-of select="years" />
            </td> 
        </tr>              
    </xsl:template>

</xsl:stylesheet>
