package com.parkinglot.demo.core.domain.parking;

import com.parkinglot.demo.core.domain.parkingspot.ParkingSpot;
import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;

public class Parkings {

    public static Parking of(Vehicle vehicle, ParkingSpot parkingSpot, ParkingTicket ticket) {
        GeneralParking parking = new GeneralParking();
        parking.setOccupyingSpot(parkingSpot);
        parking.setParkingVehicle(vehicle);
        parking.setParkingTicket(ticket);
        return parking;
    }
}
