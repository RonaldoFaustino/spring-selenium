package com.udemy.spring.springselenium.kelvin.service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Lazy
@Service
public class ScreenshotService {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}/")
    private Path path;

    @Autowired
    private JavascriptExecutor js;

    @PostConstruct
    private void init(){
        for(int i=0;i < 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sleeping....");
        }
    }

    public void takeScreenShot(final String imgName) throws IOException {
        File sourceFile =  this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(imgName +""+data()+".png").toFile());
    }

    public String data(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        Date data = new Date();
        String newDate = sdf.format(data);
        return newDate.replace("","").replace(":","");
    }

}
