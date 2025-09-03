package aedev.guru.DependencyInjection.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import aedev.guru.DependencyInjection.services.IMockService;

@Controller
public class ConstructorInjectedController {
    
    private final IMockService mockService;

    public ConstructorInjectedController(@Qualifier("simpleMock") IMockService mockService) {
        this.mockService = mockService;
    }

    public String sayHello() {
        return mockService.sayGreeting();
    }
}
