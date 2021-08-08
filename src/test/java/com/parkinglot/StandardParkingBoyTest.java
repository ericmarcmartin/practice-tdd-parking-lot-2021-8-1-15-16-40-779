package com.parkinglot;

import com.exceptions.NoPositionAvailableException;
import com.exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_the_car_given_parking_lot_and_standard_parking_boy_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_the_car_given_parking_lot_with_parked_car_and_standard_parking_boy_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //when
        Car actualCar = standardParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_parking_lot_with_2_parked_cars_and_standard_parking_boy_and_2_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car spongeBobCar = new Car();
        Car patrickCar = new Car();
        ParkingTicket spongeBobParkingTicket = standardParkingBoy.park(spongeBobCar);
        ParkingTicket patrickParkingTicket = standardParkingBoy.park(patrickCar);

        //when
        Car actualSpongeBobCar = standardParkingBoy.fetch(spongeBobParkingTicket);
        Car actualPatrickCar = standardParkingBoy.fetch(patrickParkingTicket);

        //then
        assertEquals(spongeBobCar, actualSpongeBobCar);
        assertEquals(patrickCar, actualPatrickCar);
    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_standard_parking_boy_and_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                standardParkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_parking_lot_and_standard_parking_boy_and_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        parkingLot.fetch(parkingTicket);

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingLot.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_nothing_with_error_message_when_park_the_car_given_parking_lot_without_any_position_and_parking_boy_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        parkingLot.park(new Car());
        Car car = new Car();

        //when & then
        Exception exception = assertThrows(NoPositionAvailableException.class, () ->
                standardParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_car_from_parking_1_when_park_the_car_given_standard_parking_boy_with_2_available_parking_lots_and_car() {
        //given
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(2),
                new ParkingLot(2)
        );
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
        assertEquals(car, parkingLotList.get(0).fetch(parkingTicket));
    }

    @Test
    public void should_return_car_from_parking_lot_2_when_park_the_car_given_standard_parking_boy_where_parking_lot_1_is_full_and_2_has_space_and_car() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(1),
                new ParkingLot(1)
        );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        standardParkingBoy.park(new Car());


        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
        assertEquals(car, parkingLotList.get(1).fetch(parkingTicket));
    }

    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_standard_parking_boy_with_2_parking_lot_both_with_parked_car_and_2_ticket() {
        //given
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(2),
                new ParkingLot(2)
        );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car spongeBobCar = new Car();
        Car patrickCar = new Car();
        ParkingTicket spongeBobParkingTicket = standardParkingBoy.park(spongeBobCar);
        ParkingTicket patrickParkingTicket = standardParkingBoy.park(patrickCar);

        //when
        Car actualSpongeBobCar = standardParkingBoy.fetch(spongeBobParkingTicket);
        Car actualPatrickCar = standardParkingBoy.fetch(patrickParkingTicket);

        //then
        assertEquals(spongeBobCar, actualSpongeBobCar);
        assertEquals(patrickCar, actualPatrickCar);
    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_standard_parking_boy_with_2_parking_lots_and_an_unrecognized_ticket() {
        //given
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(2),
                new ParkingLot(2)
        );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                standardParkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_nothing_with_error_message_when_fetch_the_car_given_standard_parking_boy_with_2_parking_lots_and_used_ticket() {
        //given
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(2),
                new ParkingLot(2)
        );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(parkingTicket);

        //when && then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->
                standardParkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_with_error_message_when_park_the_car_given_standard_parking_boy_with_2_fully_occupied_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = Arrays.asList(
                new ParkingLot(1),
                new ParkingLot(1)
        );
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        standardParkingBoy.park(new Car());
        standardParkingBoy.park(new Car());

        //when && then
        Exception exception = assertThrows(NoPositionAvailableException.class, () ->
                standardParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
}
