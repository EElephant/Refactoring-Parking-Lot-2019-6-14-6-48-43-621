package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.Ticket;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class Story1Test {

    // AC1
    @Test
    public void should_return_ticket_when_call_park_given_car(){
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        assertThat(ticket, notNullValue());
    }

    @Test
    public void should_return_car_when_call_fetch_given_ticket(){
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(ticket);
        assertThat(car1,notNullValue());
    }

    // AC2
    @Test
    public void should_return_multiple_tickets_when_call_park_given_cars(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();

        Ticket t1 = parkingBoy.park(car1);
        Ticket t2 = parkingBoy.park(car2);

        assertThat(t1,notNullValue());
        assertThat(t2,notNullValue());
    }

    @Test
    public void should_return_multiple_cars_when_call_fetch_given_tickets(){
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car1 = new Car();
        Car car2 = new Car();

        Ticket t1 = parkingBoy.park(car1);
        Ticket t2 = parkingBoy.park(car2);

        Car t1_car = parkingBoy.fetch(t1);
        Car t2_car = parkingBoy.fetch(t2);

        assertThat(car1,is(t1_car));
        assertThat(car2,is(t2_car));
    }

    //AC 3
    @Test
    public void should_return_null_when_call_fetch_given_wrong_ticket(){
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car1 = new Car();

        parkingBoy.park(car1);
        Ticket t2 = new Ticket();

        Car car = parkingBoy.fetch(t2);

        assertEquals(car, null);
    }

    @Test
    public void should_return_null_when_call_fetch_given_null(){
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car1 = new Car();

        parkingBoy.park(car1);

        Car car = parkingBoy.fetch(null);

        assertEquals(car, null);
    }

    //AC 4
    @Test
    public void should_return_null_when_call_fetch_given_used_ticket(){
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car = new Car();

        Ticket ticket = parkingBoy.park(car);

        Car car1 = parkingBoy.fetch(ticket);
        Car car2 = parkingBoy.fetch(ticket);

        assertThat(car1, notNullValue());
        assertEquals(car2, null);
    }

    //AC 5
    @Test
    public void should_return_null_when_call_park_given_twenty_cars_and_one_parkingLot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i=0;i<20;i++){
            parkingBoy.park(new Car());
        }
        Car car_11 = new Car();
        Ticket ticket = parkingBoy.park(car_11);
        assertEquals(ticket, null);

    }

    // AC exact01
    @Test
    public void should_return_null_when_call_park_given_the_same_car_and_one_parkingLot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Ticket ticket1 = parkingBoy.park(car);
        Ticket ticket2 = parkingBoy.park(car);

        assertThat(ticket1, notNullValue());
        assertEquals(ticket2, null);
    }

    // AC exact02
    @Test
    public void should_return_null_when_call_park_given_null(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = parkingBoy.park(null);
        assertEquals(ticket1, null);
    }
}
