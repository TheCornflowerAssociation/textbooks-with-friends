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
    
    public Users() {
        super();
    }

    public ArrayList<Lister> getListers() {
        return listers;
    }
    public boolean userExists(String email) {
        for (Lister lister : listers) {
            if (lister.getEmail().equals(email))
                return true;
        }
        return false;
    }
    public void addUser(Lister lister) {
        listers.add(lister);
    }
    public void removeUser(Lister lister) {
        listers.remove(lister);
    }
    public Lister login(String email, String password) {
        // For each user in the list...
        for (Lister lister : listers) {
            if (lister.getEmail().equals(email) && lister.getPassword().equals(password))
                return lister; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
}
