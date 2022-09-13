package com.udemy.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
@Lazy
@Configuration
@Profile("!remote")
public class WebDriverConfig {

//    @Bean
//    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
//    public WebDriver chromeDriver(){
//        WebDriverManager.chromedriver().browserVersion("104.0.5112.79").setup();
//        return new ChromeDriver();
//    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().browserVersion("104.0.5112.79").setup();
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    //@Primary
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}
