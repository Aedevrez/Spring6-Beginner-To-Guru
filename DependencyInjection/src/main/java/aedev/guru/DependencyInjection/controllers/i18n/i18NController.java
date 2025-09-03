package aedev.guru.DependencyInjection.controllers.i18n;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import aedev.guru.DependencyInjection.services.IMockService;

@Controller
public class i18NController {
    private final IMockService mockService;

    public i18NController(@Qualifier("i18N") IMockService mockService) {
        this.mockService = mockService;
    }

    public String sayHello() {
        return mockService.sayGreeting();
    }
}
