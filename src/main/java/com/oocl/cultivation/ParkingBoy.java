package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket";
    public static final String NOT_ENOUGH_POSITION = "Not enough position";
    public static final String UNRECOGNIZE_PARKING_TICKET = "Unrecognize parking ticket";
    private final List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkingLot(parkingLotList);
        return lot.park(car);
    }

    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().filter(lot -> lot.getTicketCarMap().size()!=lot.getMax()).findFirst()
                .orElseThrow(() -> new NotEnoughtPositionException(NOT_ENOUGH_POSITION));
    }

    public Car fetch(ParkingTicket parkingTicket) throws RuntimeException {
        Optional.ofNullable(parkingTicket).orElseThrow(() -> new NoTicketException(PLEASE_PROVIDE_YOUR_PARKING_TICKET));
        return  parkingLotList.stream().filter(lot -> lot.getTicketCarMap().containsKey(parkingTicket))
                .map(lot -> lot.fetch(parkingTicket)).findFirst()
                .orElseThrow(() -> new UnrecognizeParkingTicketException(UNRECOGNIZE_PARKING_TICKET));
    }


}
