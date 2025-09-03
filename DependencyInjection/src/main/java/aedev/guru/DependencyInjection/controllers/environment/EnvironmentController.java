package aedev.guru.DependencyInjection.controllers.environment;

import org.springframework.stereotype.Controller;

import aedev.guru.DependencyInjection.services.IEnvironmentService;

@Controller
public class EnvironmentController {
    private final IEnvironmentService environmentService;

    public EnvironmentController(IEnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String displayEnv() {
        return "You are in " + environmentService.getEnv() + " environment.";
    }
}
