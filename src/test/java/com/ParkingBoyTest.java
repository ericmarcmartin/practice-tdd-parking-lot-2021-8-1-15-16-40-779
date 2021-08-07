package com;

import com.exceptions.UnrecognizedParkingTicketException;
import com.parkinglot.Car;
import com.parkinglot.ParkingBoy;
import com.parkinglot.ParkingLot;
import com.parkinglot.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_standard_parking_boy_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_a_parked_car_when_fetch_the_car_given_parking_lot_with_a_parked_car_and_standard_parking_boy_and_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car actualCar = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_parking_lot_with_two_parked_cars_and_a_standard_parking_boy_and_two_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car spongeBobCar = new Car();
        Car patrickCar = new Car();
        ParkingTicket spongeBobParkingTicket = parkingBoy.park(spongeBobCar);
        ParkingTicket patrickParkingTicket = parkingBoy.park(patrickCar);

        //when
        Car actualSpongeBobCar = parkingBoy.fetch(spongeBobParkingTicket);
        Car actualPatrickCar = parkingBoy.fetch(patrickParkingTicket);

        //then
        assertEquals(spongeBobCar, actualSpongeBobCar);
        assertEquals(patrickCar, actualPatrickCar);
    }

    @Test
    public void should_return_nothing_when_fetch_the_car_given_parking_lot_and_a_standard_parking_boy_and_a_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }


}
