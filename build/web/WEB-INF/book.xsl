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
    
    <xsl:template match="book">
        <div class="card">
            <h4 class="card-header">
                <xsl:value-of select="title"/>
            </h4>
            <div class="card-body">
                <h5 class="card-title">
                    by 
                    <xsl:value-of select="author"/>
                </h5>
                
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Condition</th>
                            <th scope="col">Edition</th>
                            <th scope="col">Publisher</th>
                            <th scope="col">Year</th>
                            <th scope="col">Status</th>
                            <th scope="col">Lister</th>
                            <th scope="col">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates/>
                    </tbody>
                </table>
                
                <xsl:if test="count(bookCopy) = 0">
                    <h5 class="text-center">No books to display</h5>
                </xsl:if>
                
                <xsl:element name="a">
                    <xsl:attribute name="href">
                        <xsl:text disable-output-escaping="yes"><![CDATA[form.jsp?form=add_copy&isbn=]]></xsl:text>
                        <xsl:value-of select="isbn"/>
                    </xsl:attribute>
                    <xsl:attribute name="class">
                        <xsl:text>btn btn-primary float-right</xsl:text>
                    </xsl:attribute>
                    <xsl:text>Add Copy</xsl:text>
                </xsl:element>
                
                <xsl:if test="count(bookCopy) = 0">
                    <form action="/textbooks-with-friends/action/book" method="post">
                        <input type="hidden" name="action" value="delete"/>
                        <xsl:element name="input">
                            <xsl:attribute name="type">
                                <xsl:text>hidden</xsl:text>
                            </xsl:attribute>
                            <xsl:attribute name="name">
                                <xsl:text>isbn</xsl:text>
                            </xsl:attribute>
                            <xsl:attribute name="value">
                                <xsl:value-of select="isbn"/>
                            </xsl:attribute>
                        </xsl:element>
                        <button type="submit" name="submit" class="btn btn-danger">Remove Book</button>
                    </form>
                </xsl:if>
            </div>
        </div>
    </xsl:template>
    
    <xsl:template match="isbn">
        <p class="card-text"><b>ISBN: </b><xsl:apply-templates/></p>
    </xsl:template>
    
    <xsl:template match="description">
        <p class="card-text"><b>Description: </b><xsl:apply-templates/></p>
        <br/>
    </xsl:template>
    
    <xsl:template match="title"/>
    <xsl:template match="author"/>
    <xsl:template match="category"/>
    
    <xsl:template match="bookCopy">
        <tr>
            <th><xsl:value-of select="id"/></th>
            <td><xsl:value-of select="condition"/></td>
            <td><xsl:value-of select="edition"/></td>
            <td><xsl:value-of select="publisher"/></td>
            <td><xsl:value-of select="year"/></td>
            <td>
                <xsl:element name="a">
                    <xsl:attribute name="href">
                        <xsl:text disable-output-escaping="yes"><![CDATA[form.jsp?form=reserve&isbn=]]></xsl:text>
                        <xsl:value-of select="../isbn"/>
                        <xsl:text disable-output-escaping="yes"><![CDATA[&copyId=]]></xsl:text>
                        <xsl:value-of select="id"/>
                    </xsl:attribute>
                    <xsl:attribute name="class">
                        <xsl:text>btn btn-primary</xsl:text>
                    </xsl:attribute>
                    <xsl:text>Reserve this Book</xsl:text>
                </xsl:element>
            </td>
            <td><xsl:value-of select="lister"/></td>
            <td>
                <form action="/textbooks-with-friends/action/copy" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <xsl:element name="input">
                        <xsl:attribute name="type">
                            <xsl:text>hidden</xsl:text>
                        </xsl:attribute>
                        <xsl:attribute name="name">
                            <xsl:text>copyId</xsl:text>
                        </xsl:attribute>
                        <xsl:attribute name="value">
                            <xsl:value-of select="id"/>
                        </xsl:attribute>
                    </xsl:element>
                    <xsl:element name="input">
                        <xsl:attribute name="type">
                            <xsl:text>hidden</xsl:text>
                        </xsl:attribute>
                        <xsl:attribute name="name">
                            <xsl:text>isbn</xsl:text>
                        </xsl:attribute>
                        <xsl:attribute name="value">
                            <xsl:value-of select="../isbn"/>
                        </xsl:attribute>
                    </xsl:element>
                    <button type="submit" name="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
