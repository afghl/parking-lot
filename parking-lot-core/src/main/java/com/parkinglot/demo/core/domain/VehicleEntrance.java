package com.parkinglot.demo.core.domain;

import com.parkinglot.demo.core.domain.parking.Parking;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import com.parkinglot.demo.core.exception.NoParkingSpotException;

import java.time.LocalDateTime;

public interface VehicleEntrance {

    Parking enter(Vehicle vehicle, LocalDateTime time) throws NoParkingSpotException;
}
