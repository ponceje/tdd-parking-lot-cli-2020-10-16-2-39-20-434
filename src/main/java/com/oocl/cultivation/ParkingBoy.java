package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket";
    public static final String NOT_ENOUGH_POSITION = "Not enough position";
    public static final String UNRECOGNIZE_PARKING_TICKET = "Unrecognize parking ticket";
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkinglot(parkingLotList);
        return lot.park(car);
    }

    public ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        for(ParkingLot lot: parkingLotList){
            if(lot.getTicketCarMap().size()!=lot.getMax()){
                return lot;
            }
        }
        throw new RuntimeException(NOT_ENOUGH_POSITION);
    }

    public Car fetch(ParkingTicket parkingTicket) throws RuntimeException {
        if(parkingTicket != null){
            ParkingLot parkingLot = parkingLotList.stream().filter(lot -> lot.getTicketCarMap().containsKey(parkingTicket)).findAny()
                    .orElseThrow(() -> new RuntimeException(UNRECOGNIZE_PARKING_TICKET));
            return  parkingLot.fetch(parkingTicket);
        }
        throw new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
    }

    public Car fetch(){
        throw new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
    }

}
