package com.udemy.spring.springselenium.props;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseJunitTest {

    @Autowired
    private ResourceLoader loader;

    @Test
    public void propsTest() throws IOException {
        Properties  properties = PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
        System.out.println(properties);
    }
}
