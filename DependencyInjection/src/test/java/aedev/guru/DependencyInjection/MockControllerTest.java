package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import aedev.guru.DependencyInjection.controllers.MockController;

@SpringBootTest
public class MockControllerTest {
    @Test
    void greetingTest() {
        MockController mockController = new MockController();
        mockController.sayHello();
    }
}
