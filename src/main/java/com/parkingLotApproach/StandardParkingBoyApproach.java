package com.parkingLotApproach;

import com.exceptions.NoPositionAvailableException;
import com.parkinglot.ParkingLot;

import java.util.List;

public class StandardParkingBoyApproach implements ParkingApproach{
    @Override
    public ParkingLot retrieveParkingLotFromList(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().
                filter(ParkingLot::parkingLotIsNotFull).findFirst().orElseThrow(
                NoPositionAvailableException::new);
    }
}
