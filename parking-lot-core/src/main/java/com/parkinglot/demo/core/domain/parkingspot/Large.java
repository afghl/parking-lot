package com.parkinglot.demo.core.domain.parkingspot;

import com.parkinglot.demo.core.domain.vehicle.Vehicle;
import com.parkinglot.demo.core.domain.vehicle.VehicleType;

class Large extends ParkingSpot {
    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle != null && vehicle.getVehicleType() == VehicleType.van;
    }
}
