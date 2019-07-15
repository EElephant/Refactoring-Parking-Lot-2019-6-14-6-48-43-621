package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.Ticket;
import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Story2Test {

    @Test
    public void should_return_unrecognized_parking_ticket_when_call_fetch_given_null_and_query_message(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        Car car = parkingBoy.fetch(ticket);

        String message = parkingBoy.query();

        assertEquals(car,null);
        assertThat(message, is("Unrecognized parking ticket."));
    }

    @Test
    public void should_return_unrecognized_parking_ticket_when_call_fetch_given_used_ticket_and_query_message(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        parkingBoy.fetch(ticket);
        parkingBoy.fetch(ticket);
        String message = parkingBoy.query();
        assertThat(message, is("Unrecognized parking ticket."));
    }
    //AC2
    @Test
    public void should_return_please_provide_your_parking_ticket_when_call_fetch_given_null_and_query_message(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car  = parkingBoy.fetch(null);
        String message = parkingBoy.query();
        assertEquals(car,null);
        assertThat(message, is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_not_enough_position_when_call_fetch_given_eleven_cars_and_query_messag_and_one_parkingLot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i = 0; i < 30; i++)
            parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(new Car());
        String message = parkingBoy.query();

        assertEquals(ticket,null);
        assertThat(message, is("Not enough position."));
    }


}
