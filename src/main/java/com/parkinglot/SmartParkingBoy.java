package com.parkinglot;

import com.parkingLotApproach.SmartParkingBoyApproach;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);

    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        parkingApproach = new SmartParkingBoyApproach();
    }
}
