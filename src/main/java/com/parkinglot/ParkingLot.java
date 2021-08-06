package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    int capacity = 10;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }


    public ParkingTicket park(Car car) {
            ParkingTicket parkingTicket = new ParkingTicket();

            parkedPosition.put(parkingTicket, car);

            capacity++;
            return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (!parkingTicket.isUsed()) {
            parkingTicket.setUsed();
            return parkedPosition.get(parkingTicket);
        }
        return null;
    }
}
