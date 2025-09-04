package aedev.guru.MVC;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aedev.guru.MVC.controllers.BeerController;

@SpringBootTest
public class BeerControllerTest {
    @Autowired
    BeerController beerController;

    @Test
    void testGetBeerById() {
        System.out.println(beerController.getBeerById(UUID.randomUUID()));
    }
}
