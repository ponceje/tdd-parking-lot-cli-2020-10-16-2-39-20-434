package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkinglot(super.getParkingLotList());
        return lot.park(car);
    }

    private ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        return  parkingLotList.stream().max(Comparator.comparing(ParkingLot::getEmpty))
                .filter(c -> c.getTickatCarMapSize()!=c.getMax())
                .orElseThrow(() -> new RuntimeException(NOT_ENOUGH_POSITION));
    }
}
