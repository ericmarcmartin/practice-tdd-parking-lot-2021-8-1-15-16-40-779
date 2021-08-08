package com.parkinglot;

import com.exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_smart_parking_boy_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_a_parked_car_when_fetch_the_car_given_parking_lot_with_a_parked_car_and_smart_parking_boy_and_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //when
        Car actualCar = smartParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_parking_lot_with_two_parked_cars_and_a_smart_parking_boy_and_two_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car spongeBobCar = new Car();
        Car patrickCar = new Car();
        ParkingTicket spongeBobParkingTicket = smartParkingBoy.park(spongeBobCar);
        ParkingTicket patrickParkingTicket = smartParkingBoy.park(patrickCar);

        //when
        Car actualSpongeBobCar = smartParkingBoy.fetch(spongeBobParkingTicket);
        Car actualPatrickCar = smartParkingBoy.fetch(patrickParkingTicket);

        //then
        assertEquals(spongeBobCar, actualSpongeBobCar);
        assertEquals(patrickCar, actualPatrickCar);
    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_a_smart_parking_boy_and_a_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                smartParkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_a_smart_parking_boy_and_a_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        parkingLot.fetch(parkingTicket);

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingLot.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }
}