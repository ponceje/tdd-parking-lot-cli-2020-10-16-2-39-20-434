package com.oocl.cultivation;


public class ParkingBoy {
    private ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) throws RuntimeException {
        return parkingLot.fetch(ticket);
    }
    public Car fetch(){
        throw new RuntimeException("Please provide your parking ticket");
    }
}
