package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_super_smart_parking_boy_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_a_parked_car_when_fetch_the_car_given_parking_lot_with_a_parked_car_and_super_smart_parking_boy_and_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        //when
        Car actualCar = superSmartParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }
}