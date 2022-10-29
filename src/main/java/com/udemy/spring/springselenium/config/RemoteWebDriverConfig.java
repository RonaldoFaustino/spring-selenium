package com.udemy.spring.springselenium.config;

import com.udemy.spring.springselenium.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.net.URL;
import java.time.Duration;

@Profile("remote")
@LazyConfiguration
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
//        FirefoxProfile profile = new FirefoxProfile();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);

        return new RemoteWebDriver(this.url, new FirefoxOptions());
    }

    @Bean
    @ConditionalOnMissingBean()
    public WebDriver remoteChromeDriver(){

        return new RemoteWebDriver(this.url,new ChromeOptions());
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
