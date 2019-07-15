package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.Manager;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.Ticket;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Story6Test {

    //AC 1
    @Test
    public void shoule_return_management_list_when_pariking_lot_service_manager_call_addManagerList_given_parking_boy(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingBoy parkingBoy3 = new ParkingBoy();
        

        manager.addParkingBoy(parkingBoy1);
        manager.addParkingBoy(parkingBoy2);
        manager.addParkingBoy(parkingBoy3);

        List<ParkingBoy> list = manager.getList();
        assertThat(list,notNullValue());
    }

    @Test
    public void should_return_true_when_parkingLotManager_call_checkParkingBoyAuthorityByParkingList_given_parkingBoy(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingBoy parkingBoy3 = new ParkingBoy();

        manager.addParkingBoy(parkingBoy1);
        manager.addParkingBoy(parkingBoy2);

        boolean result1 = manager.checkParkingBoyAuthorityByParkingList(parkingBoy1);
        boolean result2 = manager.checkParkingBoyAuthorityByParkingList(parkingBoy3);

        assertThat(result1,is(true));
        assertThat(result2,is(false));
    }

    //AC 2
    @Test
    public void should_retrun_ticket_when_parkingManager_call_park_given_car(){
        Manager manager = new Manager();
        Car car = new Car();
        Ticket ticket = manager.park(car);
        assertThat(ticket,notNullValue());
    }

    @Test
    public void should_retrun_car_when_parkingManager_call_fetch_given_ticket(){
        Manager manager = new Manager();
        Car car = new Car();
        Ticket ticket = manager.park(car);
        Car car1 = manager.fetch(ticket);
        assertThat(car1,notNullValue());
    }

    @Test
    public void should_return_ticket_when_parkingLotManager_call_fetch_given_eleven_car(){
        Manager manager = new Manager();
        for (int i=0;i<10;i++){
            Car car = new Car();
            manager.park(car);
        }
        Car car_11 = new Car();
        Ticket ticket = manager.park(car_11);
        assertThat(ticket,notNullValue());
    }

    //AC 3
    @Test
    public void should_return_unrecognized_parking_ticket_when_parkingLotManager_call_fetch_given_wrongTicket_and_query_message(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        manager.addParkingBoy(parkingBoy);
        Car car = parkingBoy.fetch(ticket);
        String message = manager.queryMsgByParkingBoy(ticket);

        assertEquals(car,null);
        assertThat(message, is("Unrecognized parking ticket."));
    }

    @Test
    public void should_return_please_provide_your_parking_ticket_when_parkingLotMnanager_call_fetch_given_null_ticket_and_query_message(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.addParkingBoy(parkingBoy);
        Car car  = parkingBoy.fetch(null);
        String message = manager.queryMsgByParkingBoy(null);
        assertEquals(car,null);
        assertThat(message, is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_not_enough_position_when_parkingLotManager_call_fetch_given_eleven_cars_and_query_messag(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.addParkingBoy(parkingBoy);
        for(int i = 0; i < 20; i++)
            parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(new Car());
        String message = manager.queryMsgByParkingBoy(ticket);

        assertEquals(ticket,null);
        assertThat(message, is("Not enough position."));
    }
}
