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
 * @author Laurence Presland
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Reservation implements Serializable {
    private String isbn;
    private int copyId;
    private String name;
    private String email;

    public Reservation(String isbn, int copyId, String name, String email) {
        this.isbn = isbn;
        this.copyId = copyId;
        this.name = name;
        this.email = email;
    }
    
    public Reservation() {
        super();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
