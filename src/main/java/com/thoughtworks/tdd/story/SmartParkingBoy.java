package com.thoughtworks.tdd.story;

public class SmartParkingBoy extends ParkingBoy{

    private ParkingLot parkingLot = new ParkingLot(10);
    private ParkingLot secondParkingLot = new ParkingLot(20);
    private static final int EMPTYNUMBER = 0;
    private static final int FIRSTPARKINGLOT = 1;
    private static final int SECONDPARKINGLOT = 2;

    public Ticket park(Car car) {
        if(parkingLot.getAvalidPositionCount() >= secondParkingLot.getAvalidPositionCount()) {
            if (!parkingLot.isFull()) {
                return parkingLot.getTicketByCar(car);
            }else if (!secondParkingLot.isFull()){
                return secondParkingLot.getTicketByCar(car);
            }
        }else {
            if (!secondParkingLot.isFull()) {
                return secondParkingLot.getTicketByCar(car);
            }
        }
        return null;
    }

    public int getLotPositionCountByLot(int i){
        if(i == FIRSTPARKINGLOT)
            return parkingLot.getAvalidPositionCount();
        if(i == SECONDPARKINGLOT)
            return secondParkingLot.getAvalidPositionCount();
        else
            return EMPTYNUMBER;
    }
}
