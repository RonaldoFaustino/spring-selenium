package com.udemy.spring.springselenium.scope;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SeniorJuniorTest extends SpringBaseJunitTest {

    @Autowired
    private JuniorEngg juniorEngg;

    @Autowired
    private SeniorEngg seniorEngg;

    @Test
    public void scopeTest(){
        juniorEngg.setAmount(100);
        System.out.println("Junior :: + " + this.juniorEngg.getSalary().getAmount());
        seniorEngg.setAmount(300);
        System.out.println("Senior :: + " + this.seniorEngg.getSalary().getAmount());
        System.out.println("Junior :: + " + this.juniorEngg.getSalary().getAmount());
    }
}
