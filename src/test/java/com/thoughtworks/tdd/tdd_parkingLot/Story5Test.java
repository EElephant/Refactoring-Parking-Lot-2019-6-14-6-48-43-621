package com.thoughtworks.tdd.tdd_parkingLot;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.SuperSmartParkingBoy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Story5Test {
    @Test
    public void should_return_9_18_when_call_get_lot_position_count_given_three_car_in_10_and_20_position_parkingLot(){
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        superSmartParkingBoy.park(car1);
        superSmartParkingBoy.park(car2);
        superSmartParkingBoy.park(car3);

        assertThat(superSmartParkingBoy.getLotPositionCountByLot(1), is(9));
        assertThat(superSmartParkingBoy.getLotPositionCountByLot(2), is(18));
    }
}
