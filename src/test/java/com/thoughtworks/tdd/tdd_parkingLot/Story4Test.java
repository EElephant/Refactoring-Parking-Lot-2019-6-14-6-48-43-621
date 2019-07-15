package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.SmartParkingBoy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class Story4Test {

    @Test
    public void should_return_10_17_when_call_get_lot_position_count_given_three_car(){
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);

        assertThat(smartParkingBoy.getLotPositionCountByLot(1), is(10));
        assertThat(smartParkingBoy.getLotPositionCountByLot(2), is(17));
    }
}
