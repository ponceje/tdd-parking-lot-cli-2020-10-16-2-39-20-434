package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //WHEN
        ParkingTicket ticket = smartParkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_car_when_fetching_given_a_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket ticket = smartParkingBoy.park(car);

        //WHEN
        Car fetchedCar = smartParkingBoy.fetch(ticket);

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
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket ticket1 = smartParkingBoy.park(car1);
        ParkingTicket ticket2 = smartParkingBoy.park(car2);

        //WHEN
        Car fetchedCar1 = smartParkingBoy.fetch(ticket1);
        Car fetchedCar2 = smartParkingBoy.fetch(ticket2);

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
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{smartParkingBoy.fetch(wrongTicket); });
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_no_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(car);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{smartParkingBoy.fetch(null); });
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_empty_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(car);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{smartParkingBoy.fetch(); });
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_used_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket ticket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{smartParkingBoy.fetch(ticket); });
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
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(car1);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{smartParkingBoy.park(car2); });
        //THEN
        assertSame("Not enough position", exception.getMessage());
    }
    @Test
    public void should_return_car_ticket_when_parking_given_car_while_parking_lot_1_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkinglot2 = new ParkingLot(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkinglot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);
        smartParkingBoy.park(car4);
        smartParkingBoy.park(car5);
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car6);
        smartParkingBoy.park(car7);
        //WHEN
        smartParkingBoy.park(car8);
        //THEN
        assertEquals(5,parkingLot1.getTicketCarMap().size());
        assertEquals(4,parkinglot2.getTicketCarMap().size());
    }
}