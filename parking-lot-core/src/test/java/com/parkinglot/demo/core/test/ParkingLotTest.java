package com.parkinglot.demo.core.test;

import com.parkinglot.demo.core.domain.ParkingLot;
import com.parkinglot.demo.core.ParkingLotFactory;
import com.parkinglot.demo.core.domain.parking.Parking;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import com.parkinglot.demo.core.domain.vehicle.VehicleType;
import com.parkinglot.demo.core.exception.NoParkingSpotException;
import com.parkinglot.demo.core.exception.TicketNotPaidException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class ParkingLotTest {
    @Test
    public void factoryCanBuildParkingLot() {
        ParkingLot parkingLot = ParkingLotFactory.build(5);
        Assert.assertNotNull(parkingLot);
    }

    @Test
    public void canParkCars() throws NoParkingSpotException {
        ParkingLot parkingLot = ParkingLotFactory.build(5);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.van);
        Parking parking = parkingLot.enter(vehicle, LocalDateTime.now());
        Assert.assertNotNull(parking);
        Assert.assertNotNull(parking.getTicket());
    }

    @Test(expected = NoParkingSpotException.class)
    public void parkingHasLimit() throws NoParkingSpotException {
        ParkingLot parkingLot = ParkingLotFactory.build(1);

        int carNums = 1000;
        while (carNums-- > 0) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(VehicleType.van);
            parkingLot.enter(vehicle, LocalDateTime.now());
        }
    }

    @Test(expected = TicketNotPaidException.class)
    public void cannotExitUnlessPaid() throws NoParkingSpotException, TicketNotPaidException {
        ParkingLot parkingLot = ParkingLotFactory.build(5);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.van);
        Parking parking = parkingLot.enter(vehicle, LocalDateTime.now());
        Vehicle car = parkingLot.exit(parking, LocalDateTime.now().plusHours(3));
    }
}
