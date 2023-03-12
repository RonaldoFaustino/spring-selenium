package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MultiBrowserTest extends SpringBaseJunitTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest(){

        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
