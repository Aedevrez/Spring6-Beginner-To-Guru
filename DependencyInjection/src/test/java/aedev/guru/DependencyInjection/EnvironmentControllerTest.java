package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import aedev.guru.DependencyInjection.controllers.environment.EnvironmentController;

@ActiveProfiles({"prod", "EN"})
@SpringBootTest
public class EnvironmentControllerTest {
    @Autowired
    EnvironmentController environmentController;

    @Test
    void testDisplayEnv() {
        System.out.println(environmentController.displayEnv());
    }
}
