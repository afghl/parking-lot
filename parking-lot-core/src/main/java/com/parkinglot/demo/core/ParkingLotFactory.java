package com.parkinglot.demo.core;

public class ParkingLotFactory {

    public static ParkingLot build() {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot;
    }
}
