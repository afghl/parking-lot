package com.parkinglot.demo.core.domain;

import com.parkinglot.demo.core.domain.parking.Parking;
import com.parkinglot.demo.core.domain.parking.Parkings;
import com.parkinglot.demo.core.domain.parkingspot.ParkingSpot;
import com.parkinglot.demo.core.domain.ticket.ParkingTicket;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import com.parkinglot.demo.core.exception.NoParkingSpotException;
import com.parkinglot.demo.core.exception.TicketNotPaidException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * parking lot model
 */
public class ParkingLot implements VehicleEntrance, VehicleExit {

    /**
     * one parking lot should have multi parking floor
     */
    private List<ParkingFloor> parkingFloors = new ArrayList<>();

    @Override
    public Parking enter(Vehicle vehicle, LocalDateTime time) throws NoParkingSpotException {
        ParkingSpot parkingSpot = getSpotOf(vehicle);
        if (parkingSpot == null) {
            throw new NoParkingSpotException();
        }

        ParkingTicket ticket = ParkingTicket.getTicket(time);
        parkingSpot.parkCar(vehicle);

        return Parkings.of(vehicle, parkingSpot, ticket);
    }

    @Override
    public Vehicle exit(Parking parking, LocalDateTime time) throws TicketNotPaidException {
        if (!parking.getTicket().isPaid()) {
            throw new TicketNotPaidException();
        }
        return parking.getCar();
    }

    public void addParkingFloor(ParkingFloor floor) {
        assert floor != null;
        parkingFloors.add(floor);
    }

    private ParkingSpot getSpotOf(Vehicle vehicle) {
        return parkingFloors.stream()
                .map(ParkingFloor::getParkingSpots)
                .flatMap(Collection::stream)
                .filter(ParkingSpot::available)
                .filter(s -> s.canPark(vehicle))
                .findFirst()
                .orElse(null);
    }
}
