package aedev.guru.DependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import aedev.guru.DependencyInjection.controllers.MockController;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		MockController mockController = ctx.getBean(MockController.class);

		System.out.println("In application context");

		System.out.println(mockController.sayHello());
	}

}
