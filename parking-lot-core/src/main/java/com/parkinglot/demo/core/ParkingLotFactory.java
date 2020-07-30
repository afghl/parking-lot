package com.parkinglot.demo.core;

import com.parkinglot.demo.core.model.ParkingLot;

import java.util.ArrayList;

public class ParkingLotFactory {

    // TODO: user build pattern
    public static ParkingLot build(int floorSize) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingFloors(new ArrayList<>());
        return parkingLot;
    }
}
