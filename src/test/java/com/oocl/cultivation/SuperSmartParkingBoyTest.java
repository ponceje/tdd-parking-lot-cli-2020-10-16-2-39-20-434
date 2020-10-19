package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //WHEN
        ParkingTicket ticket = superSmartParkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_car_when_fetching_given_a_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingTicket ticket = superSmartParkingBoy.park(car);

        //WHEN
        Car fetchedCar = superSmartParkingBoy.fetch(ticket);

        //THEN
        assertSame(car, fetchedCar);
    }
    @Test
    public void should_return_correct_car_when_fetching_given_multiple_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingTicket ticket1 = superSmartParkingBoy.park(car1);
        ParkingTicket ticket2 = superSmartParkingBoy.park(car2);

        //WHEN
        Car fetchedCar1 = superSmartParkingBoy.fetch(ticket1);
        Car fetchedCar2 = superSmartParkingBoy.fetch(ticket2);

        //THEN
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }
    @Test
    public void should_return_exception_when_fetching_given_wrong_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> superSmartParkingBoy.fetch(wrongTicket));
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_no_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(car);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> superSmartParkingBoy.fetch(null));
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_used_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingTicket ticket = superSmartParkingBoy.park(car);
        superSmartParkingBoy.fetch(ticket);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> superSmartParkingBoy.fetch(ticket));
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_parking_given_car_while_parking_lot_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(car1);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> superSmartParkingBoy.park(car2));
        //THEN
        assertSame("Not enough position", exception.getMessage());
    }
    @Test
    public void should_return_car_ticket_when_parking_given_car_while_parking_lot_1_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        IntStream.range(0, 8).forEach(cars -> {
            Car carsNew = new Car();
            superSmartParkingBoy.park(carsNew);
        });
        Car car = new Car();
        //WHEN
        superSmartParkingBoy.park(car);
        //THEN
        assertEquals(3,parkingLot1.getTicketCarMap().size());
        assertEquals(6,parkingLot2.getTicketCarMap().size());
    }
}