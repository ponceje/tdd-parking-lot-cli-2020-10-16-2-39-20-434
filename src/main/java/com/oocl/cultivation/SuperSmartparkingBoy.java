package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartparkingBoy extends ParkingBoy{
    public SuperSmartparkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    public ParkingTicket park(Car car) {
        ParkingLot lot = getParkinglot(super.getParkingLotList());
        return lot.park(car);
    }
    private ParkingLot getParkinglot(List<ParkingLot> parkingLotList) {
        ParkingLot lot = parkingLotList.stream().min(Comparator.comparing(ParkingLot::getRate))
                .filter(c -> c.getTickatCarMapSize()!=c.getMax())
                .orElseThrow(() -> new RuntimeException(NOT_ENOUGH_POSITION));
        return lot;
    }
}
