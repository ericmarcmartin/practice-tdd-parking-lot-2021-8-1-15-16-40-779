package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_the_car_given_parking_lot_with_parked_car_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        Car car = new Car();

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(actualCar, car);
    }

}