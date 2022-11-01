package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import com.udemy.spring.springselenium.kelvin.service.ScreenshotService;
import com.udemy.spring.springselenium.page.google.GooglePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class )
public class GoogleTest extends SpringBaseJunitTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotService screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        /*
        this.googlePage.goTo();

        Assert.assertTrue(this.googlePage.isAt());

        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("environment ");
        //this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot("google");
        System.out.println("Final Test Google Test");
        this.googlePage.close();
        */
    }

}
