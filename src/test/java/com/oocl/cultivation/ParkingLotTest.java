package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_lot(){
        //GIVEN
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //WHEN
        ParkingTicket parkingTicket = parkingLot.park(car);

        //THEN
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_a_car_when_fetching_given_a_gaming_ticket_to_parking_lot(){
        //GIVEN
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //WHEN
        Car fetchedCar = parkingLot.fetch(parkingTicket);

        //THEN
        assertEquals(car,fetchedCar);
    }

}