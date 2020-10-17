package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> manageList = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public List<ParkingBoy> getManageList() {
        return null;
    }
}
