package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_smart_parking_boy_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }
}