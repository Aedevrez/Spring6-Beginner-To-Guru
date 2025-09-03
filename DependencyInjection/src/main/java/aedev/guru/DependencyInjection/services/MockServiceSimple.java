package aedev.guru.DependencyInjection.services;

import org.springframework.stereotype.Service;

@Service("simpleMock")
public class MockServiceSimple implements IMockService {

    @Override
    public String sayGreeting() {
        System.out.println("Inside the service");
        return "Hello!";
    }
    
}
