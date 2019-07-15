package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story3Test {
    @Test
    public void should_return_ticket_when_call_fetch_given_eleven_car(){
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i = 0; i < 10; i++)
            parkingBoy.park(new Car());

        Ticket ticket = parkingBoy.park(new Car());
        assertThat(ticket,notNullValue());
    }
}
