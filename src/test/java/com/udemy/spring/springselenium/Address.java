package com.udemy.spring.springselenium;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String street;

    public Address(){
        this.street = "123 non Main st";
    }

    public String getStreet() {
        return street;
    }
}
