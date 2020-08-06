package com.parkinglot.demo.core.domain.parking;

import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;

import java.time.LocalDateTime;

public interface Parking {

    ParkingTicket getTicket();

    Vehicle getCar();

    /**
     * check parking fee of current time
     * @return
     */
    Double checkParkingFee(LocalDateTime time);
}

