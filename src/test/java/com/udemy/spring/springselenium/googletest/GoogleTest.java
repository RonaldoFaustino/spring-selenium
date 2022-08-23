package com.udemy.spring.springselenium.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.spring.springselenium.SpringBaseJunitTest;
import com.udemy.spring.springselenium.google.GooglePage;
import com.udemy.spring.springselenium.util.ScreenShotUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleTest extends SpringBaseJunitTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("environment ");
        //this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot("google");
    }
}
