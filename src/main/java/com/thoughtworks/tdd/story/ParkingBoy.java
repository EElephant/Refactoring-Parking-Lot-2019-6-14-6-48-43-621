package com.thoughtworks.tdd.story;

public class ParkingBoy {

    private ParkingLot parkingLot = new ParkingLot(10);
    private ParkingLot secondParkingLot = new ParkingLot(10);


    public Ticket park(Car car) {
//        Ticket ticket = null;
        Ticket ticket = parkingLot.getTicketByCar(car);
        if(parkingLot.isFull()){
            if (!secondParkingLot.isFull())
                ticket = secondParkingLot.getTicketByCar(car);
            if (secondParkingLot.isFull())
                ticket = null;
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingLot.getCarByTicket(ticket);
        return car;
    }

    public String query() {
        return parkingLot.queryMessage();
    }


}
