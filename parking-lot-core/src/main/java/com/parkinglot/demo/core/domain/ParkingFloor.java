package com.parkinglot.demo.core.domain;

import com.parkinglot.demo.core.domain.parkingspot.ParkingSpot;
import com.parkinglot.demo.core.domain.parkingspot.ParkingSpots;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ParkingFloor {

    @Getter
    private List<ParkingSpot> parkingSpots;

    private ParkingDisplayBoard parkingDisplayBoard;

    private CustomerInfoPortal customerInfoPortal;

    private ParkingFloor() {}

    public static ParkingFloor buildDefault() {
        ParkingFloor floor = new ParkingFloor();

        floor.parkingSpots = Arrays.asList(
                ParkingSpots.random(floor),
                ParkingSpots.random(floor),
                ParkingSpots.random(floor)
        );

        floor.parkingDisplayBoard = new ParkingDisplayBoard();
        floor.customerInfoPortal = new CustomerInfoPortal();

        return floor;
    }
}
