/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author J-Mo
 */

@XmlRootElement(name="users")
public class Users implements Serializable {
    
    @XmlElement(name="lister")
    private ArrayList<Lister> listers = new ArrayList<Lister>();
    
    /**
     * A constructor for the users object
     *
     */
    public Users() {
        super();
    }

    /**
     * Get the list of listers
     *
     * @return
     */
    public ArrayList<Lister> getListers() {
        return listers;
    }

    /**
     * Check if a specific user exists
     *
     * @param email - The email of the user to check
     * @return
     */
    public boolean userExists(String email) {
        for (Lister lister : listers) {
            if (lister.getEmail().equals(email))
                return true;
        }
        return false;
    }

    /**
     * Add a new user
     *
     * @param lister - The lister to add
     */
    public void addUser(Lister lister) {
        listers.add(lister);
    }

    /**
     * Remove a specific user
     *
     * @param lister - The lister to remove
     */
    public void removeUser(Lister lister) {
        listers.remove(lister);
    }

    /**
     * Authenticate a user
     *
     * @param email - The email of the user to be authenticated
     * @param password - The password of the user to be authenticated
     * @return
     */
    public Lister login(String email, String password) {
        // For each user in the list...
        for (Lister lister : listers) {
            if (lister.getEmail().equals(email) && lister.getPassword().equals(password))
                return lister; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
}
