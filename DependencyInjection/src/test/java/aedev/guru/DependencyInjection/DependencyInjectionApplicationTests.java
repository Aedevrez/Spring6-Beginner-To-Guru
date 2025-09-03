package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import aedev.guru.DependencyInjection.controllers.MockController;

@SpringBootTest
class DependencyInjectionApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MockController mockController;

	@Test
	void getDirectlyFromMockController() {
		String result = mockController.sayHello();
		System.out.println(result);
	}

	@Test
	void getBeanFromContext() {
		MockController mockController = applicationContext.getBean(MockController.class);
		System.out.println(mockController.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
