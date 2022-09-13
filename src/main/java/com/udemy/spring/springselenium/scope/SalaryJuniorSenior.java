package com.udemy.spring.springselenium.scope;

import org.springframework.stereotype.Component;

@Component
public class SalaryJuniorSenior {

    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
