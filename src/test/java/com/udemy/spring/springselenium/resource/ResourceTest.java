package com.udemy.spring.springselenium.resource;

import com.udemy.spring.springselenium.SpringBaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ResourceTest extends SpringBaseJunitTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("classpath:data/testdata2.csv")
    private Resource resource2;

    @Value("file:C:\\Exemplo SpringBoot\\spring-selenium\\src\\test\\resources\\data\\testdata.csv")
    private Resource fileAbsolute;

    @Value("https://www.google.com")
    private Resource url;

    @Value("https://www.w3.org/Protocols/rfc1341/7_1_Text.html")
    private Resource url2;

    @Value("${screenshot.path}/some.txt")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);

        Files.readAllLines(fileAbsolute.getFile().toPath())
                .forEach(System.out::println);

        String teste = new String(String.valueOf(url.getInputStream().markSupported()));
        System.out.println(teste);
    }

    @Test
    public void resourceTest2() throws IOException {

        System.out.println(new String(url.getInputStream().readAllBytes()));
    }

    @Test
    public void resourceTest3() throws IOException {
        System.out.println(new String(url2.getInputStream().readAllBytes()));
    }

    @Test
    public void resourceTest4() throws IOException {
        FileCopyUtils.copy(url2.getInputStream(), Files.newOutputStream(path));
    }

    @Test
    public void resourceTest5() throws IOException {
        FileCopyUtils.copy(url2.getInputStream(), Files.newOutputStream(path));
    }

//    @Test(dataProvider = "getData")
//    public void resourceTest(String url, String saveas) throws IOException {
//        FileCopyUtils.copy(
//                resourceLoader.getResource(url).getInputStream(),
//                Files.newOutputStream(path.resolve(saveas));
//        )
//    }
//
//
//    @DataProvider
//    public Stream<String[]> getData() throws IOException {
//        return Files.readAllLines(resource.getFile().toPath())
//                .stream()
//                .map(s -> s.split(",")) Stream<String[]>
//                .toArray(Object[][]::new);
//    }
}
