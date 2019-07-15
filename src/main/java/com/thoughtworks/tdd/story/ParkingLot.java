package com.thoughtworks.tdd.story;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkingInfo = new HashMap<>();
    private int position = 10;
    private String message;

    public ParkingLot(int position){
        this.position = position;
    }

    public Ticket getTicketByCar(Car car) {
        if(position == parkingInfo.size()){
            message = "Not enough position.";
            return null;
        }
        if(parkingInfo.values().contains(car))
            return null;
        if(car == null)
            return null;
        Ticket ticket = new Ticket();
        parkingInfo.put(ticket,car);
        return ticket;
    }

    public Car getCarByTicket(Ticket ticket){
        if(ticket == null)
            message = "Please provide your parking ticket.";
        else if(parkingInfo.get(ticket) == null)
            message = "Unrecognized parking ticket.";

        Car car = parkingInfo.remove(ticket);
        return car;
    }

    public String queryMessage(){
        String str = message;
        message = "";
        return str;
    }

    public boolean isFull(){
        return parkingInfo.size() == position;
    }

    public int getAvalidPositionCount(){
        return position - parkingInfo.size();
    }

    public int getPosition(){
        return this.position;
    }
}
