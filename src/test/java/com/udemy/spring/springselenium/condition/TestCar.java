package com.udemy.spring.springselenium.condition;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCar extends SpringBaseJunitTest {

    @Autowired
    private Car car;

    @Test
    public void carTest(){
        this.car.run();
    }
}
