package com.parkinglot.demo.core.domain.parking;

import com.parkinglot.demo.core.domain.parkingspot.ParkingSpot;
import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    @Override
    public Double checkParkingFee(LocalDateTime time) {
        if (getTicket().isPaid()) {
            return getTicket().getPaidFee();
        }

        long passedHours = ChronoUnit.HOURS.between(getTicket().getStartTime(), time);

        if (passedHours <= 0) {
            return 2.0;
        }

        if (passedHours > 0) {
            return 3.0 * passedHours;
        }

        return 0.0;
    }
}
