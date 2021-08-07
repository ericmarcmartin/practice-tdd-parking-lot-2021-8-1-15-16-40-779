package com.parkinglot;

import com.exceptions.NoPositionAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        Optional<ParkingLot> found = Optional.empty();
        for (ParkingLot parkingLot : parkingLotList) {
            if (hasAvailableParkingSpace(parkingLot)) {
                found = Optional.of(parkingLot);
                break;
            }
        }
        ParkingLot parkingLotStream = found
                .orElseThrow(NoPositionAvailableException::new);

        return parkingLotStream.park(car);
    }

    private boolean hasAvailableParkingSpace(ParkingLot currentParkingLot) {
        return currentParkingLot.getOccupiedCapacity() < currentParkingLot.getCapacity();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return Objects.requireNonNull(parkingLotList
                .stream()
                .findFirst()
                .orElse(null)).fetch(parkingTicket);
    }
}
