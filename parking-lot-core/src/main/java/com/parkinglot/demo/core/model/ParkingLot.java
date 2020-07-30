package com.parkinglot.demo.core.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * parking lot model
 */
public class ParkingLot {

    /**
     * one parking lot should have multi parking floor
     */
    @Getter @Setter
    private List<ParkingFloor> parkingFloors;
}
