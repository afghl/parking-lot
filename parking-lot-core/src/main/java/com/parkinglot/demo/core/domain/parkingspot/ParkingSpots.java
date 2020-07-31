package com.parkinglot.demo.core.domain.parkingspot;

import com.parkinglot.demo.core.domain.ParkingFloor;

public class ParkingSpots {

    public static ParkingSpot random(ParkingFloor floor) {
        Large spot = new Large();
        spot.parkingFloor = floor;
        return spot;
    }
}
