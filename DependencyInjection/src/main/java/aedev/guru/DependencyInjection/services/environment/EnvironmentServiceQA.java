package aedev.guru.DependencyInjection.services.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import aedev.guru.DependencyInjection.services.IEnvironmentService;

@Profile("qa")
@Service
public class EnvironmentServiceQA implements IEnvironmentService{

    @Override
    public String getEnv() {
        return "qa";
    }
    
}
