package aedev.guru.DependencyInjection.controllers;

import org.springframework.stereotype.Controller;

import aedev.guru.DependencyInjection.services.IMockService;
import aedev.guru.DependencyInjection.services.MockServiceSimple;

@Controller
public class MockController {
    private IMockService mockService;

    public MockController() {
        this.mockService = new MockServiceSimple();
    }

    public String sayHello() {
        System.out.println("In the mock controller");
        return mockService.sayGreeting();
    }
}
