package com.parkinglot.demo.core.domain.parking;

import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;

public interface Parking {

    ParkingTicket getTicket();

    Vehicle getCar();
}

