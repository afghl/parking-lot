package com.parkinglot.demo.core.domain.parking;

import com.parkinglot.demo.core.domain.parkingspot.ParkingSpot;
import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

public class GeneralParking implements Parking {

    @Setter
    private ParkingTicket parkingTicket;
    @Setter
    private ParkingSpot occupyingSpot;
    @Setter
    private Vehicle parkingVehicle;

    @Override
    public ParkingTicket getTicket() {
        return parkingTicket;
    }

    @Override
    public Vehicle getCar() {
        return parkingVehicle;
    }
}
