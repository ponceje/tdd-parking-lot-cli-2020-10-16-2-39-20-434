package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest {

    @Test
    public void should_return_a_parking_boy_list_when_getting_manage_list_parking_given_parking_manager_adding_parking_boys() {
        //GIVEN
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
        Car fetchedCar = parkingManager.commandFetch(parkingBoy, parkingTicket);

        //THEN
        assertEquals(car,fetchedCar);
    }
    @Test
    public void should_return_a_null_when_command_park_given_parking_manager_with_a_car_to_specific_parking_boy_not_in_his_manage_list() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
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
        ParkingTicket parkingTicket = parkingManager.commandPark(new ParkingBoy(parkingLots), car);

        //THEN
        assertNull(parkingTicket);
    }
    @Test
    public void should_return_a_null_when_command_fetch_given_parking_manager_with_a_parking_ticket_to_specific_parking_boy_not_in_his_manage_list() {
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
        Car carFetched = parkingManager.commandFetch(new ParkingBoy(parkingLotForParkingBoy), parkingTicket);

        //THEN
        assertNull(carFetched);
    }
    @Test
    public void should_parking_lot_size_1_when_command_parking_given_car_while_parking_lot_1_is_at_max_capacity_from_parking_manager_to_smart_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(smartParkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        parkingManager.setManageList(parkingBoys);

        parkingManager.commandPark(smartParkingBoy,car1);

        //WHEN
        parkingManager.commandPark(smartParkingBoy,car2);
        //THEN
        assertEquals(1,parkingLot2.getTicketCarMap().size());
    }
    @Test
    public void should_return_correct_parking_lot_size_when_command_parking_given_car_while_parking_lot_1_is_at_max_capacity_from_parking_manager_to_super_smart_parking_boy(){
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(superSmartParkingBoy);

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        parkingManager.setManageList(parkingBoys);

        IntStream.range(0, 7).forEach(cars -> {
            Car carsNew = new Car();
            parkingManager.commandPark(superSmartParkingBoy,carsNew);
        });
        //WHEN
        parkingManager.commandPark(superSmartParkingBoy,new Car());
        //THEN
        assertEquals(3,parkingLot1.getTicketCarMap().size());
        assertEquals(5,parkingLot2.getTicketCarMap().size());
    }
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_manager() {
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        //WHEN
        ParkingTicket ticket = parkingManager.park(car);

        //THEN
        assertNotNull(ticket);
    }
    @Test
    public void should_return_a_car_when_fetching_given_a_parking_ticket_to_parking_manager(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingManager parkingManager = new ParkingManager(parkingLots);
        ParkingTicket ticket = parkingManager.park(car);

        //WHEN
        Car fetchedCar = parkingManager.fetch(ticket);

        //THEN
        assertSame(car, fetchedCar);
    }
    @Test
    public void should_return_exception_when_fetching_given_manager_has_wrong_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingManager.setManageList(parkingBoys);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> parkingManager.commandFetch(parkingBoy,wrongTicket));
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_manager_has_no_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car);

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingManager.setManageList(parkingBoys);

        //WHEN
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class,
                ()-> parkingManager.commandFetch(parkingBoy,null));
        //THEN
        assertSame("Please provide your parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_fetching_given_manager_has_used_parking_ticket_to_parking_boy(){
        //GIVEN
        Car car = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingManager.setManageList(parkingBoys);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> parkingManager.commandFetch(parkingBoy,ticket));
        //THEN
        assertSame("Unrecognize parking ticket", exception.getMessage());
    }
    @Test
    public void should_return_exception_when_parking_given_manager_has_car_while_parking_lot_is_at_max_capacity_to_parking_boy(){
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);

        ParkingManager parkingManager = new ParkingManager(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingManager.setManageList(parkingBoys);

        //WHEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                ()-> parkingManager.commandPark(parkingBoy,car2));
        //THEN
        assertSame("Not enough position", exception.getMessage());
    }

}