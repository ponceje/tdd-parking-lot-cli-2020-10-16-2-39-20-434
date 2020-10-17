package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkinglot(super.getParkingLotList());
        return lot.park(car);
    }
    private ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        ParkingLot lot = parkingLotList.stream().min(Comparator.comparing(ParkingLot::getTickatCarMapSize))
                .filter(c -> c.getTickatCarMapSize()!=c.getMax())
                .orElseThrow(() -> new RuntimeException(NOT_ENOUGH_POSITION));
        return lot;
    }
}
