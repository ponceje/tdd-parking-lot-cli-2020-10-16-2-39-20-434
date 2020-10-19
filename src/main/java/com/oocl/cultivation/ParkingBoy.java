package com.oocl.cultivation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket";
    public static final String NOT_ENOUGH_POSITION = "Not enough position";
    public static final String UNRECOGNIZE_PARKING_TICKET = "Unrecognize parking ticket";
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkingLot(parkingLotList);
        return lot.park(car);
    }

    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().filter(lot -> lot.getTicketCarMap().size()!=lot.getMax()).findFirst()
                .orElseThrow(() -> new RuntimeException(NOT_ENOUGH_POSITION));
    }

    public Car fetch(ParkingTicket parkingTicket) throws RuntimeException {
        Optional.ofNullable(parkingTicket).orElseThrow(() -> new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET));
        ParkingLot parkingLot = parkingLotList.stream().filter(lot -> lot.getTicketCarMap().containsKey(parkingTicket)).findAny()
                .orElseThrow(() -> new RuntimeException(UNRECOGNIZE_PARKING_TICKET));
        return  parkingLot.fetch(parkingTicket);
    }

    public Car fetch(){
        throw new RuntimeException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
    }

}
