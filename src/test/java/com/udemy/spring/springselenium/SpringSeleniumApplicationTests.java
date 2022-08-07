package com.udemy.spring.springselenium;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Autowired
	private User user;

	@Autowired
	private Faker faker;

	@Value("${TEST_URL:http://www.google.com}")
	private String url;

	@Value("${fruits}")
	private List<String> fruits;

	@Value("${myusername}")
	private String username;

	@Test
	void contextLoads() {
		System.out.println(this.url);
		this.user.printDetails();
		Faker faker = new Faker();
		System.out.println(faker.name().firstName() +" "+ faker.name().lastName());
	}

	/*Address address = new Address();
		Salary salary = new Salary();
		User user = new User(address,salary);
		user.printDetails();
	*/
}
