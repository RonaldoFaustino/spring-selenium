package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.kelvin.annotation.annotation.PageFragment;
import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@PageFragment
public class SearchComponent extends Base {

    @FindBy(xpath = "//input[@class=\"gLFyf gsfi\"]")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void search(final String Keyword){
        this.searchBox.sendKeys(Keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns.stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
