package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_car_when_fetching_given_a_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket ticket = parkingBoy.park(car);

        //WHEN
        Car fetchedCar = parkingBoy.fetch(ticket);

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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);

        //WHEN
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);

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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.fetch(wrongTicket); });
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_no_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.fetch(null); });
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_empty_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.fetch(); });
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_used_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.fetch(ticket); });
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.park(car2); });
        //THEN
        assertSame("Not enough position", exception.getMessage());
    }
    @Test
    public void should_return_size_slot_of_parking_lot2_when_parking_given_car_while_parking_lot_1_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkinglot2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);

        //WHEN
        parkingBoy.park(car2);
        //THEN
        assertEquals(1, parkinglot2.getTicketCarMap().size());
    }
    @Test
    public void should_return_car_when_parking_given_ticket_for_car_while_parking_lot_1_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);
        ParkingTicket ticket = parkingBoy.park(car2);
        //WHEN
        Car fetchedCar = parkingBoy.fetch(ticket);
        //THEN
        assertEquals(car2,fetchedCar);
    }
}
