package com.parkinglot.demo.core;

import com.parkinglot.demo.core.domain.ParkingFloor;
import com.parkinglot.demo.core.domain.ParkingLot;

import java.util.ArrayList;

public class ParkingLotFactory {

    public static ParkingLot build(int floorSize) {
        ParkingLot parkingLot = new ParkingLot();

        int i = floorSize;
        while (i-- > 0) {
            ParkingFloor floor = ParkingFloor.buildDefault();
            parkingLot.addParkingFloor(floor);
        }
        return parkingLot;
    }
}
