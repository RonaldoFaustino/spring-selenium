package com.udemy.spring.springselenium.fligths;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("laguage/en.properties")
public class FligthAppDetails {


    @Value("${fligth.app.url}")
    private String url;

    @Value("${fligth.app.labels}")
    private List<String> labels;

    public String getUrl() {
        return url;
    }

    public List<String> getLabels() {
        return labels;
    }
}
