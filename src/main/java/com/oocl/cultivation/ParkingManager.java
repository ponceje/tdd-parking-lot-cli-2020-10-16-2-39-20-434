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
        ParkingTicket parkingTicket= parkingBoy.park(car);
        return parkingTicket;
    }

    public static Car commandFetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        return null;
    }

}
