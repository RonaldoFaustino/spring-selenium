package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import com.udemy.spring.springselenium.google.GooglePage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoogleTest extends SpringBaseJunitTest {

    @Autowired
    private GooglePage googlePage;

    @Test
    public void googleTest(){
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    }
}
