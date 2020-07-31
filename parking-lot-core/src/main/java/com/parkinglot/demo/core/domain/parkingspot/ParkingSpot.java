package com.parkinglot.demo.core.domain.parkingspot;

import com.parkinglot.demo.core.domain.ParkingFloor;
import com.parkinglot.demo.core.domain.vehicle.Vehicle;

public abstract class ParkingSpot {

    protected SpotStatus status = SpotStatus.available;

    protected Vehicle vehicle;

    protected ParkingFloor parkingFloor;

    public abstract boolean canPark(Vehicle vehicle);

    public boolean available() {
        return status == SpotStatus.available;
    }

    public void parkCar(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.status = SpotStatus.occupied;
    }

    public Vehicle release() {
        Vehicle v = this.vehicle;
        this.vehicle = null;
        this.status = SpotStatus.available;
        return v;
    }
}
