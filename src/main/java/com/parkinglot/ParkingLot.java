package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    int capacity = 10;
    int occupiedCapacity = 0;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }


    public ParkingTicket park(Car car) {
        if (occupiedCapacity < capacity) {
            ParkingTicket parkingTicket = new ParkingTicket();

            parkedPosition.put(parkingTicket, car);

            occupiedCapacity++;
            return parkingTicket;
        }
        throw new NoPositionAvailableException();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(isUnrecognizedTicket(parkingTicket)) {
           throw new UnrecognizedParkingTicketException();
        }
        if (!parkingTicket.isUsed()) {
            parkingTicket.setUsed();
            return parkedPosition.get(parkingTicket);
        }
        return null;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkedPosition.containsKey(parkingTicket) || parkingTicket.isUsed();
    }
}
