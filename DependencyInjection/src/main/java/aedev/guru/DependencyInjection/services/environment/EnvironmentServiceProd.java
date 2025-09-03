package aedev.guru.DependencyInjection.services.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import aedev.guru.DependencyInjection.services.IEnvironmentService;

@Profile("prod")
@Service
public class EnvironmentServiceProd implements IEnvironmentService{

    @Override
    public String getEnv() {
        return "prod";
    }
    
}
