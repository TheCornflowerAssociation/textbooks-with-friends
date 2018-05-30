/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author J-Mo
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Lister implements Serializable {
    // Fields
    
    @XmlElement(name = "username")
    private String username;
    
    @XmlElement(name = "email")
    private String email;
    
    @XmlElement(name = "password")
    private String password;

    // Constructors

    /**
     * A constructor for the Lister object
     *
     */
    public Lister() {
        super();
    }

    /**
     * A constructor for the Lister object
     *
     * @param username - The username of the lister
     * @param email - The email of the lister
     * @param password - The password of the lister
     */
    public Lister(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }


    // Getters & Setters

    /**
     * Get the username of the lister
     *
     * @return
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Get the email of the lister
     *
     * @return
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Get the password of the lister
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the username of the lister
     *
     * @param username - The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Get the email of the lister
     *
     * @param email - The email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the password of the lister
     *
     * @param password - The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
