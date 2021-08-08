package com.parkingLotApproach;

import com.exceptions.NoPositionAvailableException;
import com.parkinglot.ParkingLot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoyApproach implements ParkingApproach{
    @Override
    public ParkingLot retrieveParkingLotFromList(List<ParkingLot> parkingLotList) {
        return parkingLotList
                .stream()
                .max(Comparator.comparingDouble(ParkingLot::getPositionRate))
                .orElseThrow(NoPositionAvailableException::new);
    }
}
