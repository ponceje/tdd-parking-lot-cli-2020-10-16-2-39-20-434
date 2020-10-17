package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket";
    public static final String NOT_ENOUGH_POSITION = "Not enough position";
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkinglot(parkingLotList);
        return lot.park(car);
    }

    private ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        for(ParkingLot lot: parkingLotList){
            if(lot.getTicketCarMap().size()!=lot.getMax()){
                return lot;
            }
        }
        throw new RuntimeException(NOT_ENOUGH_POSITION);
    }

    public Car fetch(ParkingTicket parkingTicket) throws RuntimeException {
        if (parkingTicket != null){
            for (ParkingLot lot: parkingLotList) {
                if(lot.getTicketCarMap().containsKey(parkingTicket)){
                    return lot.fetch(parkingTicket);
                }
            }
            throw new RuntimeException("Unrecognize parking ticket");
        }
        throw new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
    }

    public Car fetch(){
        throw new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
    }
    public List<ParkingLot> getParkingLotList(){
        return parkingLotList;
    }
}
