package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    public ParkingTicket park(Car car){
        ParkingTicket ticket = new ParkingTicket(car);
        if (ticketCarMap.size() < 10) {
            ticketCarMap.put(ticket, car);
        } else {
            ticket = null;
        }
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }
}
