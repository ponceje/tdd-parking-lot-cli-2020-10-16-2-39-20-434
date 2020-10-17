package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int max = 10;
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot() { }

    public ParkingLot(int max) {
        this.max = max;
    }

    public ParkingTicket park(Car car){
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public int getTickatCarMapSize(){
        return ticketCarMap.size();
    }

    public int getMax(){
        return max;
    }
    public int getRate(){
        return ticketCarMap.size()/max;
    }
}
