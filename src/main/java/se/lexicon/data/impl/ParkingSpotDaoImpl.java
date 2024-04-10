package se.lexicon.data.impl;

import se.lexicon.model.ParkingSpot;

import java.util.*;

import static java.time.chrono.HijrahChronology.INSTANCE;

public class ParkingSpotDaoImpl {
    //todo: Implement necessary methods
    private static final ParkingSpotDaoImpl Instance = new ParkingSpotDaoImpl();
    private Map<Integer, List<ParkingSpot>> ParkingSpotByAreaCode new HashMap<>();
    private ParkingSpotDaoImpl() {}

    public static ParkingSpotDaoImpl getInstance() {
        return Instance;
    }

    @Override
    public ParkingSpot adSpot(ParkingSpot spot) {
        int areaCode = spot.getAreaCode();
        ParkingSpotByAreaCode.computeIfAbsent(areaCode, k -> new ArrayList<>()).add(spot);
        return spot;
    }
    @Override
    public Optional<ParkingSpot> findSpot(int spotNumber, int areaCode) {
        List<ParkingSpot> spotsInArea = ParkingSpotByAreaCode.get(areaCode);
        if(spotsInArea != null) {
            for (ParkingSpot spot : spotsInArea) {
                if (spot.getSpotNumber() == spotNumber) {
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();
    }

    @override
    public List<ParkingSpot> getSpotByArea(int areaCode) {
        return parkingSpotsByAreaCode.getOfDefault(areaCode, new ArrayList<>());
    }

    public void oocupyParkingSpot(int spotNumber, int areaCode) {
        findSpot(spotNumber,areaCode).ifPresent(ParkingSpot :: isOccupied);
    }

    public void vacateParkingSpot(int spotNumber, int areaCode) {
        findSpot(spotNumber,areaCode).ifPresent(ParkingSpot :: vacate);
    }

    public void addSpot(ParkingSpot spot) {

    }

    public void occupyParkingSpot(int i, int i1) {

    }

    public void testVacateParkingSpot(int i, int i1) {

    }
}
