package com.parkingLotApproach;

import com.exceptions.NoPositionAvailableException;
import com.parkinglot.ParkingLot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoyApproach implements ParkingApproach {
    @Override
    public ParkingLot retrieveParkingLotFromList(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableCapacity))
                .orElseThrow(NoPositionAvailableException::new);
    }
}
