package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationDaoImplTest {
    //todo: Implement required JUnit tests

    private ReservationDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new ReservationDaoImpl();
    }
    @Test
    public void testAddReservation() {
        Reservation reservation = new Reservation("reservation",);
        testObject.addReservation();
        assertTrue(testObject.reservations.containsKey("reservation"), "Reservation should be added to the map");
    }

    @Test
    public void testFindReservationById() {
        Reservation reservation = new Reservation("reservation1");
        testObject.addReservation();
        Reservation foundReservation = testObject.findReservationById("reservation");
        assertNotNull(foundReservation, "Found reservation should not be null");
        assertEquals(reservation, foundReservation, "Found Reservation should be added to the map");
    }

    @Test
    public void testRemoveReservation() {
        Reservation reservation = new Reservation("reservation1");
        testObject.addReservation();
        testObject.removeReservation("reservation1");
        assertFalse(testObject.reservation.containskey("reservation"),
                "Reservation should be removed from the map");
    }

    @Test
    public void testUpdateReservation() {
        Reservation reservation = new Reservation("reservation1");
        testObject.addReservation();
        Reservation updatedReservation = new Reservation("reservation1");
        testObject.updatedReservation(updatedReservation);
        Reservation foundReservation = testObject.findReservationById("reservation");
        assertNotNull(foundReservation, "Updated reservation should not be null");
        assertEquals(updatedReservation, foundReservation, "Updated Reservation should be the same as the input reservation");
    }




}
