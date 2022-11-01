package com.udemy.spring.springselenium.kelvin.config;

import com.udemy.spring.springselenium.kelvin.annotation.annotation.LazyConfiguration;
import com.udemy.spring.springselenium.kelvin.annotation.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    //@Primary
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    //@Scope("prototype")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().browserVersion("107").setup();
        return new ChromeDriver();
    }

//        @Bean
//    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
//    public WebDriver chromeDriver(){
//        WebDriverManager.chromedriver().browserVersion("104.0.5112.79").setup();
//        return new ChromeDriver();
//    }
}
