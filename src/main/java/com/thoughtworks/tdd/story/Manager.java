package com.thoughtworks.tdd.story;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();
    private ParkingLot parkingLot = new ParkingLot(10);
    private ParkingLot secondParkingLot = new ParkingLot(20 );

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
    }

    public List<ParkingBoy> getList(){
        return parkingBoyList;
    }

    public boolean checkParkingBoyAuthorityByParkingList(ParkingBoy parkingBoy) {
        return parkingBoyList.contains(parkingBoy);
    }

    public Ticket park(Car car) {
        if (!parkingLot.isFull())
            return parkingLot.getTicketByCar(car);
        else if(!secondParkingLot.isFull())
            return secondParkingLot.getTicketByCar(car);
        else
            return null;
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.getCarByTicket(ticket);
    }

    public String queryMsgByParkingBoy(Ticket ticket) {
        ParkingBoy parkingBoy = parkingBoyList.get(0);
        return parkingBoy.query();
    }
}
