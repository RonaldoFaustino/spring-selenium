package com.udemy.spring.springselenium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Autowired
	private User user;

	@Value("${PATH}")
	private String path;

	@Value("${fruits}")
	private List<String> fruits;

	@Value("${myusername}")
	private String username;

	@Test
	void contextLoads() {
		System.out.println(this.fruits.get(0));
		System.out.println(this.fruits.size());
		System.out.println(this.fruits.get(0));
		System.out.println(this.path);
		System.out.println(this.username);
		//System.out.println(this.path);
	}

	/*Address address = new Address();
		Salary salary = new Salary();
		User user = new User(address,salary);
		user.printDetails();
	*/
}
