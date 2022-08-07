package com.udemy.spring.springselenium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Autowired
	private User user;

	@Test
	void contextLoads() {
		user.printDetails();
	}

	/*Address address = new Address();
		Salary salary = new Salary();
		User user = new User(address,salary);
		user.printDetails();
	*/
}
