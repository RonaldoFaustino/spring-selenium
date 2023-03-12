package com.udemy.spring.springselenium.fligths;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import com.udemy.spring.springselenium.page.fligths.FligthsPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class )
public class FligthTest extends SpringBaseJunitTest {

    @Autowired
    private FligthsPage fligthsPage;

    @Autowired
    private FligthAppDetails appDetails;

    @Test
    public  void flightTest(){

        this.fligthsPage.goTo(this.appDetails.getUrl());
        Assert.assertTrue(this.fligthsPage.isAt());

        Assert.assertEquals(this.fligthsPage.getLabel(), this.appDetails.getLabels());

        this.fligthsPage.endTo();


    }
}
