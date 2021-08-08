package com.parkinglot;

import com.parkingLotApproach.SuperSmartParkingBoyApproach;

import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy {
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        parkingApproach = new SuperSmartParkingBoyApproach();
    }
}

