package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private final Map<ParkingTicket, Car> parkingTicketCarHashMap = new HashMap<>();
    int capacity;

    public int getOccupiedCapacity() {
        return parkingTicketCarHashMap.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return getCapacity() - getOccupiedCapacity();
    }

    public ParkingLot() {
        capacity = DEFAULT_CAPACITY;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
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

    public boolean parkingLotIsNotFull() {
        return parkingTicketCarHashMap.size() < capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }

        return getCarWithMatch(parkingTicket);
    }

    private Car getCarWithMatch(ParkingTicket parkingTicket) {
        Car matchedCar = parkingTicketCarHashMap.get(parkingTicket);
        parkingTicketCarHashMap.remove(parkingTicket);

        return matchedCar;
    }

    boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkingTicketCarHashMap.containsKey(parkingTicket);
    }
}
