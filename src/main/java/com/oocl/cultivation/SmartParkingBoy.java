package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream().max(Comparator.comparing(ParkingLot::getEmpty))
                .filter(lot -> lot.getTicketCarMapSize()!=lot.getMax())
                .orElseThrow(() -> new NotEnoughtPositionException(NOT_ENOUGH_POSITION));
    }
}
