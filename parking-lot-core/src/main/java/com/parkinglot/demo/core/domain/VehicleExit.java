package com.parkinglot.demo.core.domain;

import com.parkinglot.demo.core.domain.parking.Parking;
import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import com.parkinglot.demo.core.exception.TicketNotPaidException;

import java.time.LocalDateTime;

public interface VehicleExit {

    Vehicle exit(Parking parking, LocalDateTime time) throws TicketNotPaidException;

    Vehicle payAndExit(Parking parking, LocalDateTime time);
}
