package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        parkingLot = getParkinglot(parkingLotList);
        return parkingLot.park(car);
    }

    private ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        for(ParkingLot lot: parkingLotList){
            if(lot.getTicketCarMap().size()<lot.getMax()){
                return lot;
            }
        }
        throw new RuntimeException("Not enough position");
    }

    public Car fetch(ParkingTicket ticket) throws RuntimeException {
        return parkingLot.fetch(ticket);
    }
    public Car fetch(){
        throw new RuntimeException("Please provide your parking ticket");
    }
}
