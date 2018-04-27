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

    public BookCopy(int id, String condition, boolean reserved) {
        this.id = id;
        this.condition = condition;
        this.reserved = reserved;
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
    
}
