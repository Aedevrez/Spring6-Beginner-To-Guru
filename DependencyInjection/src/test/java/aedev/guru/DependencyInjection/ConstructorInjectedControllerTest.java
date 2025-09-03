package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aedev.guru.DependencyInjection.controllers.ConstructorInjectedController;

@SpringBootTest
public class ConstructorInjectedControllerTest {
    
    @Autowired
    ConstructorInjectedController constructorInjectedController;

    /*
    @BeforeEach
    void setup() {
        this.constructorInjectedController = new ConstructorInjectedController(new MockService());
    }
    */

    @Test
    void sayHello() {
        System.out.println(constructorInjectedController.sayHello());
    }
}
