package com.oocl.cultivation;


public class ParkingBoy {
    private ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket){
        return parkingLot.fetch(ticket);
    }
    public Car fetch(){
        return null;
    }
}
