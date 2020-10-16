package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int max = 10;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot() {
    }

    public ParkingLot(int max) {
        this.max = max;
    }

    public ParkingTicket park(Car car){
        ParkingTicket ticket = new ParkingTicket(car);
        if (ticketCarMap.size() < max) {
            ticketCarMap.put(ticket, car);
        } else {
            throw new RuntimeException("Not enough position");
        }
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        if (parkingTicket == null){
            throw new RuntimeException("Please provide your parking ticket");
        }
        if(!ticketCarMap.containsKey(parkingTicket)){
            throw new RuntimeException("Unrecognize parking ticket");
        }
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);

        return car;
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public int getMax(){
        return max;
    }
}
