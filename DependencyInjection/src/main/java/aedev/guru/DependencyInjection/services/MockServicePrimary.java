package aedev.guru.DependencyInjection.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class MockServicePrimary implements IMockService {

    @Override
    public String sayGreeting() {
        return "Hello from Primary";
    }
    
}
