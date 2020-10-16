package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //WHEN
        ParkingTicket ticket = parkingBoy.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_car_when_fetching_given_a_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(car1);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()->{parkingBoy.park(car2); });
        //THEN
        assertSame("Not enough position", exception.getMessage());
    }
}
