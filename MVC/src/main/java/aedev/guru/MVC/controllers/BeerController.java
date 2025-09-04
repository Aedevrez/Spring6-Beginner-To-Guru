package aedev.guru.MVC.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;

import aedev.guru.MVC.model.Beer;
import aedev.guru.MVC.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(id);
    }
}
