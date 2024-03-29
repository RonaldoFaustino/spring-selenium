package com.udemy.spring.springselenium.page.fligths;

import com.udemy.spring.springselenium.kelvin.annotation.annotation.Page;
import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FligthsPage extends Base {

    @FindBy(css = "a.P4z3kc")
    private List<WebElement> elements;

    public void goTo( final String url){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public List<String> getLabel(){
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }

    public void endTo(){
        this.driver.quit();
    }
}
