package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> manageList = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public void setManageList(List<ParkingBoy> parkingBoys){
        this.manageList=parkingBoys;
    }

    public List<ParkingBoy> getManageList() {
        return manageList;
    }

    public ParkingTicket commandPark(ParkingBoy parkingBoy, Car car) {
        return isContains(parkingBoy)? parkingBoy.park(car): null;
    }

    public Car commandFetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        return isContains(parkingBoy)? parkingBoy.fetch(parkingTicket): null;
    }

    private boolean isContains(ParkingBoy parkingBoy) {
        return manageList.contains(parkingBoy);
    }
}
