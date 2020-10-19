package com.oocl.cultivation;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public int getTicketCarMapSize(){
        return ticketCarMap.size();
    }

    public int getMax(){
        return max;
    }

    public BigDecimal getRate(){
        return BigDecimal.valueOf(getEmpty()).divide(BigDecimal.valueOf(max),2, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100));
    }

    public int getEmpty(){ return  max-getTicketCarMapSize(); }
}
