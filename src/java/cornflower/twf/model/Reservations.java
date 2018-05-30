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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laurence Presland
 */
@XmlRootElement(name="reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservations implements Serializable {
    
    @XmlElement(name="reservation")
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    
    /**
     * A constructor for the reservations object
     *
     */
    public Reservations() {
        super();
    }
    
    /**
     * A constructor for the reservations object
     *
     * @param reservations - The reservations object to set
     */
    public Reservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    /**
     * Check if a book has been reserved
     *
     * @param isbn - The ISBN of the book
     * @param copyId - The ID of the bookCopy
     * @return
     */
    public boolean checkReserved(String isbn, int copyId) {
        for (Reservation reservation : reservations) {
            if (reservation.getIsbn().equals(isbn) && reservation.getCopyId() == copyId) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get the reservation of a specific bookCopy
     *
     * @param isbn - The ISBN of the book
     * @param copyId - The ID of the bookCopy
     * @return
     */
    public Reservation getReservation(String isbn, int copyId) {
        for (Reservation reservation : reservations) {
            if (reservation.getIsbn().equals(isbn) && reservation.getCopyId() == copyId) {
                return reservation;
            }
        }
        return null;
    }
    
    /**
     * Create or set the reservation of a particular bookCopy
     *
     * @param isbn - The ISBN of the book
     * @param copyId - The ID of the bookCopy
     * @param newReservation - The reservation ot set
     */
    public void addOrSetReservation(String isbn, int copyId, Reservation newReservation) {
        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getIsbn().equals(isbn) && reservation.getCopyId() == copyId) {
                reservation = newReservation;
                found = true;
            }
        }
        if (!found) {
            reservations.add(newReservation);
        }
    }
    
    /**
     * Get the list of reservations
     *
     * @return
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    
    /**
     * Remove a specific reservation
     *
     * @param reservation - The reservation to remove
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
