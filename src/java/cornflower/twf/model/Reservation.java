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
    private int reservationId;
    private String username;
    private int bookId;

    public Reservation(int reservationId, String username, int bookId) {
        this.reservationId = reservationId;
        this.username = username;
        this.bookId = bookId;
    }
    
    public Reservation() {
        super();
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
}
