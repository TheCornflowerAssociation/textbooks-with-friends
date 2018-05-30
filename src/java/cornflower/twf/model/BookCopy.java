/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author J-Mo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlSeeAlso({Book.class})
public class BookCopy implements Serializable {
    private int id;
    private String condition;
    private int edition;
    private int year;
    private String publisher;
    private String lister;

    /**
     * A constructor for a bookCopy
     *
     * @param id - The unique ID of the bookCopy
     * @param condition - The condition of the bookCopy
     * @param edition - The edition of the bookCopy
     * @param year - The year of publishing of the bookCopy
     * @param publisher - The publisher of the bookCopy
     * @param lister - The lister of the bookCopy
     */
    public BookCopy(int id, String condition, int edition, int year, String publisher, String lister) {
        this.id = id;
        this.condition = condition;
        this.edition = edition;
        this.year = year;
        this.publisher = publisher;
        this.lister = lister;
    }
    
    /**
     * A constructor for a bookCopy
     *
     */
    public BookCopy() {
        super();
    }
    
    /**
     * Get the ID of the bookCopy
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get the condition of the bookCopy
     *
     * @return
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Set the condition of the bookCopy
     *
     * @param condition - The new condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    /**
     * Get the edition of the bookCopy
     *
     * @return
     */
    public Integer getEdition() {
        return edition;
    }

    /**
     * Set the edition of the bookCopy
     *
     * @param edition - The new edition
     */
    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    /**
     * Get the year of the bookCopy
     *
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set the year of the bookCopy
     *
     * @param year - The new year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * Get the publisher of the bookCopy
     *
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Set the publisher of the bookCopy
     *
     * @param publisher = The new publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Get the lister of the bookCopy
     *
     * @return
     */
    public String getLister() {
        return lister;
    }

    /**
     * Set the lister of the bookCopy
     *
     * @param lister - The new lister
     */
    public void setLister(String lister) {
        this.lister = lister;
    }
    
    /**
     * Check if the lister of the bookCopy matches a given lister
     *
     * @param email - The email of the lister to check
     * @return
     */
    public boolean hasLister(String email) {
        return lister.equals(email);
    }
    
}
