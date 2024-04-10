package se.lexicon.data.impl;

import se.lexicon.model.Reservation;

import java.util.HashMap;
import java.util.Map;

public class ReservationDaoImpl {
    public Object reservation;
    //todo: Implement necessary methods
    Map<String, Reservation> reservations = new HashMap<>();

    public ReservationDaoImpl() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addReservation() {
    }

    public void updatedReservation(Reservation updatedReservation) {
    }

    public Reservation findReservationById(String reservation) {
    }

    public void removeReservation(String reservation1) {
    }
}



