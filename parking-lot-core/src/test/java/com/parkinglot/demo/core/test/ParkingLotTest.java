package com.parkinglot.demo.core.test;

import com.parkinglot.demo.core.model.ParkingLot;
import com.parkinglot.demo.core.ParkingLotFactory;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void factoryCanBuildParkingLot() {
        ParkingLot parkingLot = ParkingLotFactory.build(5);
        Assert.assertNotNull(parkingLot);
    }

    @Test
    public void oneParkingLotShouldHaveMultiFloors() {
        ParkingLot parkingLot = ParkingLotFactory.build(5);
        Assert.assertNotNull(parkingLot.getParkingFloors());
//        Assert.assertEquals(parkingLot.getParkingFloors().size(), 5);
    }
}
