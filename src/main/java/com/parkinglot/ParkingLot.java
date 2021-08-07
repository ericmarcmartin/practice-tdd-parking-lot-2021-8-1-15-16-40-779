package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<>();
    int capacity = 10;
    int occupiedCapacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }

    public ParkingLot(int capacity, int occupiedCapacity) {
        this.capacity = capacity;
        this.occupiedCapacity = occupiedCapacity;

    }

    public ParkingTicket park(Car car) {
        if (parkingLotIsNotFull()) {
            ParkingTicket parkingTicket = new ParkingTicket();

            parkingTicketCarHashMap.put(parkingTicket, car);
            return parkingTicket;
        }
        throw new NoPositionAvailableException();
    }

    private boolean parkingLotIsNotFull() {

        return parkingTicketCarHashMap.size() < capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        if (!parkingTicket.isUsed()) {
            parkingTicket.setUsed();
            return parkingTicketCarHashMap.get(parkingTicket);
        }
        return null;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkingTicketCarHashMap.containsKey(parkingTicket) || parkingTicket.isUsed();
    }
}
