package com.udemy.spring.springselenium.fligths;


import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"laguage/en.properties", "browser=firefox"})
public class EnTest extends FligthTest{
}
