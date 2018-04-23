/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.Serializable;

/**
 *
 * @author J-Mo
 */
public class BookCopy implements Serializable {
    private String condition;

    public BookCopy(String condition) {
        this.condition = condition;
    }
    
    public BookCopy() {
        super();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
}
