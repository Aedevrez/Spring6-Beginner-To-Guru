package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aedev.guru.DependencyInjection.controllers.PropertyInjectedController;

@SpringBootTest
public class PropertyInjectedControllerTest {
    @Autowired
    PropertyInjectedController propertyInjectedController;

    /*
    @BeforeEach
    void setup() {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.mockService = new MockService();
    }
    */

    @Test
    void testHello() {
        System.out.println(propertyInjectedController.sayHello());
    }
}
