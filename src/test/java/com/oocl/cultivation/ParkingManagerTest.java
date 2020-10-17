package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest {

    @Test
    public void should_return_a_parking_boy_list_when_getting_manage_list_parking_given_parking_manager_adding_parking_boys() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLotForParkingBoy = new ArrayList<>();
        parkingLotForParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSmartParkingBoy = new ArrayList<>();
        parkingLotForSmartParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSuperSmartParkingBoy = new ArrayList<>();
        parkingLotForSuperSmartParkingBoy.add(new ParkingLot());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotForParkingBoy);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotForSmartParkingBoy);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotForSuperSmartParkingBoy);
        List<ParkingBoy> parkingBoys = Arrays.asList(parkingBoy, superSmartParkingBoy,smartParkingBoy);

        List<ParkingLot> parkingLotForParkingManager = new ArrayList<>();
        parkingLotForParkingManager.add(new ParkingLot());

        ParkingManager parkingManager = new ParkingManager(parkingLotForParkingManager);
        parkingManager.setManageList(parkingBoys);
        //WHEN
        List<ParkingBoy> getManageList = parkingManager.getManageList();

        //THEN
        assertNotNull(getManageList);
    }

    @Test
    public void should_return_a_parking_ticket_when_command_park_given_parking_manager_with_a_car_to_specific_parking_boy() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLotForParkingBoy = new ArrayList<>();
        parkingLotForParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSmartParkingBoy = new ArrayList<>();
        parkingLotForSmartParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSuperSmartParkingBoy = new ArrayList<>();
        parkingLotForSuperSmartParkingBoy.add(new ParkingLot());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotForParkingBoy);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotForSmartParkingBoy);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotForSuperSmartParkingBoy);
        List<ParkingBoy> parkingBoys = Arrays.asList(parkingBoy, superSmartParkingBoy,smartParkingBoy);

        List<ParkingLot> parkingLotForParkingManager = new ArrayList<>();
        parkingLotForParkingManager.add(new ParkingLot());

        ParkingManager parkingManager = new ParkingManager(parkingLotForParkingManager);
        parkingManager.setManageList(parkingBoys);
        //WHEN
        ParkingTicket parkingTicket = parkingManager.commandPark(parkingBoy, car);

        //THEN
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_a_car_when_command_fetch_given_parking_manager_with_a_parking_ticket_to_specific_parking_boy() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLotForParkingBoy = new ArrayList<>();
        parkingLotForParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSmartParkingBoy = new ArrayList<>();
        parkingLotForSmartParkingBoy.add(new ParkingLot());

        List<ParkingLot> parkingLotForSuperSmartParkingBoy = new ArrayList<>();
        parkingLotForSuperSmartParkingBoy.add(new ParkingLot());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotForParkingBoy);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotForSmartParkingBoy);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotForSuperSmartParkingBoy);
        List<ParkingBoy> parkingBoys = Arrays.asList(parkingBoy, superSmartParkingBoy,smartParkingBoy);

        List<ParkingLot> parkingLotForParkingManager = new ArrayList<>();
        parkingLotForParkingManager.add(new ParkingLot());

        ParkingManager parkingManager = new ParkingManager(parkingLotForParkingManager);
        parkingManager.setManageList(parkingBoys);

        ParkingTicket parkingTicket = parkingManager.commandPark(parkingBoy, car);

        //WHEN
        Car fetchedCar = ParkingManager.commandFetch(parkingBoy, parkingTicket);

        //THEN
        assertEquals(car,fetchedCar);
    }
}