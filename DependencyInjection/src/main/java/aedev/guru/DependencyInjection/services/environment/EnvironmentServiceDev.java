package aedev.guru.DependencyInjection.services.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import aedev.guru.DependencyInjection.services.IEnvironmentService;

@Profile({"dev", "default"})
@Service
public class EnvironmentServiceDev implements IEnvironmentService {

    @Override
    public String getEnv() {
        return "dev";
    }
    
}
