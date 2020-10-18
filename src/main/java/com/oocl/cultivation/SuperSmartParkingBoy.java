package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().max(Comparator.comparing(ParkingLot::getRate))
                .filter(c -> c.getTickatCarMapSize()!=c.getMax())
                .orElseThrow(() -> new RuntimeException(NOT_ENOUGH_POSITION));
    }
}
