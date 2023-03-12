package com.udemy.spring.springselenium.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JuniorEngg {

    @Autowired
    private SalaryJuniorSenior salaryJuniorSenior;

    public SalaryJuniorSenior getSalary() {
        return salaryJuniorSenior;
    }

    public void setAmount(int amount){
        this.salaryJuniorSenior.setAmount(amount);
    }
}
