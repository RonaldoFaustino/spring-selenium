package com.udemy.spring.springselenium.google;

import com.udemy.spring.springselenium.annotation.Page;
import com.udemy.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${aplication.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent(){
        return searchComponent;
    };

    public SearchResult getSearchResult(){
        return searchResult;
    }


    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
