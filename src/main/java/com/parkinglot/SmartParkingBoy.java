package com.parkinglot;

import com.exceptions.NoPositionAvailableException;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public SmartParkingBoy(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);

    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLotStream = parkingLotList
                .stream()
                .filter(this::hasAvailableParkingSpace)
                .findFirst()
                .orElseThrow(NoPositionAvailableException::new);

        return parkingLotStream.park(car);
    }

    private boolean hasAvailableParkingSpace(ParkingLot currentParkingLot) {
        return currentParkingLot.getOccupiedCapacity() < currentParkingLot.getCapacity();
    }
}
