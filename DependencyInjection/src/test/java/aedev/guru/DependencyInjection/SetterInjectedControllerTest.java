package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aedev.guru.DependencyInjection.controllers.SetterInjectedController;

@SpringBootTest
public class SetterInjectedControllerTest {
    @Autowired
    SetterInjectedController setterInjectedController;

    /*
    @BeforeEach
    void setup() {
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setMockService(new MockService());
    }
    */

    @Test
    void testHello() {
        System.out.println(setterInjectedController.sayHello());
    }
}
