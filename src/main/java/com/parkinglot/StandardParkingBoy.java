package com.parkinglot;

import com.exceptions.UnrecognizedParkingTicketException;
import com.parkingLotApproach.ParkingApproach;
import com.parkingLotApproach.StandardParkingBoyApproach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLotList = new ArrayList<>();
    public ParkingApproach parkingApproach = new StandardParkingBoyApproach();

    public StandardParkingBoy(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public StandardParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingApproach.retrieveParkingLotFromList(parkingLotList);
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return Objects.requireNonNull(parkingLotList
                .stream()
                .filter(parkingLot -> isRecognizedTicket(parkingTicket, parkingLot))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new))
                .fetch(parkingTicket);
    }

    private boolean isRecognizedTicket(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        return !parkingLot.isUnrecognizedTicket(parkingTicket);
    }
}
