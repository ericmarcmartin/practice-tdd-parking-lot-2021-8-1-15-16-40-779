package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_a_standard_parking_boy_and_a_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_standard_parking_boy_and_a_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingLot.fetch(parkingTicket);

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingLot.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_nothing_with_error_message_when_park_the_car_given_parking_lot_without_any_position_and_a_parking_boy_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingLot.park(new Car());
        Car car = new Car();

        //when & then
        Exception exception = assertThrows(NoPositionAvailableException.class, () ->
                parkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_car_parked_to_the_first_lot_when_park_the_car_given_a_standard_parking_boy_with_two_parking_lots_both_available_position_and_a_parking_lot_and_car() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(2,0),
                new ParkingLot(2,0)
        );

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertEquals(car, parkingBoy.fetch(parkingTicket));
    }
}
