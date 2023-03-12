package com.udemy.spring.springselenium.condition;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestCar extends SpringBaseJunitTest {
    @Qualifier("Accord")
    @Autowired
    private Car car;

    @Test
    public void carTest(){
        this.car.run();
    }
}
