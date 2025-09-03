package aedev.guru.DependencyInjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import aedev.guru.DependencyInjection.services.MockServiceSimple;

@Controller
public class PropertyInjectedController {
    @Autowired
    public MockServiceSimple mockService;

    public String sayHello() {
        return mockService.sayGreeting();
    }
}
