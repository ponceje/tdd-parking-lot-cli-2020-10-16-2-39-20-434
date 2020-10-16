package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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
}
