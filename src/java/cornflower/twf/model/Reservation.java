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

    /**
     * A constructor for the reservation object
     *
     * @param isbn - The ISBN of the reserved book
     * @param copyId - The ID of the reserved bookCopy
     * @param name - The name of the reserver
     * @param email - The email of the reserver
     */
    public Reservation(String isbn, int copyId, String name, String email) {
        this.isbn = isbn;
        this.copyId = copyId;
        this.name = name;
        this.email = email;
    }
    
    /**
     * A constructor for the reservation object
     *
     */
    public Reservation() {
        super();
    }

    /**
     * Get the ISBN of the reserved book
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set the ISBN of the reserved book
     *
     * @param isbn - The ISBN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the ID of the reserved bookCopy
     *
     * @return
     */
    public int getCopyId() {
        return copyId;
    }

    /**
     * Set the ID of the reserved bookCopy
     *
     * @param copyId - The ID to set
     */
    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    /**
     * Get the name of the reserver
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the reserver
     *
     * @param name - The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the email of the reserver
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the reserver
     *
     * @param email - The email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
