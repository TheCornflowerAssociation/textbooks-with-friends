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
    
    public Reservations() {
        super();
    }
    
    public Reservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public Reservation getReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
    
    public void setReservation(int reservationId, Reservation newReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservation = newReservation;
            }
        }
    }
    
    public void addReservation(Reservation newReservation) {
        reservations.add(newReservation);
    }
    
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
