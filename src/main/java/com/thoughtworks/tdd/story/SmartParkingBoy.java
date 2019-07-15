package com.thoughtworks.tdd.story;

public class SmartParkingBoy extends ParkingBoy{

    private ParkingLot parkingLot = new ParkingLot(10);
    private ParkingLot secondParkingLot = new ParkingLot(20);

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
        if(i == 1)
            return parkingLot.getAvalidPositionCount();
        if(i == 2)
            return secondParkingLot.getAvalidPositionCount();
        else
            return 0;
    }
}
