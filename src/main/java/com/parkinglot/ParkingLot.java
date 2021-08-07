package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<>();
    int capacity = 10;
    int occupiedCapacity = 0;

    public int getOccupiedCapacity() {
        return occupiedCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(int capacity, int occupiedCapacity) {
        this.capacity = capacity;
        this.occupiedCapacity = occupiedCapacity;
    }

    public ParkingTicket park(Car car) {
        if (parkingLotIsNotFull()) return getParkingTicket(car);
        throw new NoPositionAvailableException();
    }

    private ParkingTicket getParkingTicket(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketCarHashMap.put(parkingTicket, car);

        return parkingTicket;
    }

    private boolean parkingLotIsNotFull() {
        return parkingTicketCarHashMap.size() < capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return getCarWithMatch(parkingTicket);
    }

    private Car getCarWithMatch(ParkingTicket parkingTicket) {
        parkingTicket.setUsed();

        return parkingTicketCarHashMap.get(parkingTicket);
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkingTicketCarHashMap.containsKey(parkingTicket) || parkingTicket.isUsed();
    }
}
