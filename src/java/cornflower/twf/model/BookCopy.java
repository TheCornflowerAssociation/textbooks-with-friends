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

/**
 *
 * @author J-Mo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BookCopy implements Serializable {
    private int id;
    private String condition;
    private boolean reserved;
    private int edition;
    private int year;
    private String publisher;
    private String lister;

    public BookCopy(int id, String condition, boolean reserved, int edition, int year, String publisher, String lister) {
        this.id = id;
        this.condition = condition;
        this.reserved = reserved;
        this.edition = edition;
        this.year = year;
        this.publisher = publisher;
        this.lister = lister;
    }
    
    public BookCopy() {
        super();
    }
    
    public int getId() {
        return id;
    }
    
    public boolean isReserved() {
        return reserved;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLister() {
        return lister;
    }

    public void setLister(String lister) {
        this.lister = lister;
    }
    
    boolean hasLister(String email) {
        return lister.equals(email);
    }
    
}
