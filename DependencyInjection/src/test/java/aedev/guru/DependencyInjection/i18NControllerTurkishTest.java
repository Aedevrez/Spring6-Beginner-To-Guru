package aedev.guru.DependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import aedev.guru.DependencyInjection.controllers.i18n.i18NController;

@ActiveProfiles("TR")
@SpringBootTest
public class i18NControllerTurkishTest {
    @Autowired
    i18NController i18nController;

    @Test
    void testHello() {
        System.out.println(i18nController.sayHello());
    }
}