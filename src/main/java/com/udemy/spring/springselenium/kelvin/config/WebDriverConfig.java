package com.udemy.spring.springselenium.kelvin.config;

import com.udemy.spring.springselenium.kelvin.annotation.annotation.LazyConfiguration;
import com.udemy.spring.springselenium.kelvin.annotation.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        WebDriverManager.chromedriver().browserVersion("110").setup();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

//options.addArguments("--headless");

        options.addArguments("--disable-notifications");

        options.addArguments("--disable-gpu");

        options.addArguments("--disable-extensions");

        options.addArguments("--no-sandbox");

        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("--remote-allow-origins=*");  // this i added  this and it worked, Thanks a ton  xinchao zhang !!

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        options.merge(capabilities);

        //new ChromeDriver(options);
        return new ChromeDriver(options);
    }

//        @Bean
//    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
//    public WebDriver chromeDriver(){
//        WebDriverManager.chromedriver().browserVersion("104.0.5112.79").setup();
//        return new ChromeDriver();
//    }
}
