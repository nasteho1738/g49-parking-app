package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingSpotDaoImplTest {
    //todo: Implement required JUnit tests
    private ParkingSpotDaoImpl testObject;
    
    @BeforeEach 
    public void setUp() {
        testObject = ParkingSpotDaoImpl.getInstance();
    }
    @Test
    public void testAddSpot() {

        ParkingSpot spot = new ParkingSpot(1,101);
        ParkingSpot adddedSpot = testObject.addSpot(spot);
        assertNotNull(adddedSpot, "added spot should not be null");
        assertEquals(spot, addedSpot, "added spot should be the same as the input spot");
}       ParkingSpot addedSpot;

    
    @Test
    public void testFindSpot() {
        ParkingSpot spot = new ParkingSpot(1,101);
        testObject.addSpot(spot);
        Optional<ParkingSpot>foundSpot = testObject.findSpot(101,1);
        assertTrue(foundSpot.isPresent(), "Found spot should be present");
        assertEquals(spot, foundSpot.get(), "Found spot should be the same as added spot"); 
    }
    
    @Test 
    public void testGetSpotByAreaCode() {
        ParkingSpot spot1 = new ParkingSpot(1,101);
        ParkingSpot spot2 = new ParkingSpot(1,102);
        testObject.addSpot(spot1);
        testObject.addSpot(spot2);
        List<ParkingSpot> spotsInArea = testObject.getSpotByArea(1);
        assertEquals(1, spotsInArea.size(), "There should be 2 spots in area 1");
        assertTrue(spotsInArea.contains(spot1), "Spot 101 should be in the list");
        assertTrue(spotsInArea.contains(spot2), "Spot 102 should be in the list");
    }
    
    @Test 
    public void testOccupyParkingSpot() {
        ParkingSpot spot = new ParkingSpot(1, 101);
        testObject.addSpot(spot);
        testObject.occupyParkingSpot(101, 1);
        assertTrue(spot.isOccupied(), "Spot should be accupied after occupyParkingSpot call");
    }

    @Test
    public void testVacateParkingSpot() {
        ParkingSpot spot = new ParkingSpot(1, 101);
        testObject.addSpot(spot);
        testObject.occupyParkingSpot(101, 1);
        testObject.testVacateParkingSpot(101, 1);
        assertTrue(spot.isOccupied(), "Spot should be vacate after vacateParkingSpot call");
    }
}
