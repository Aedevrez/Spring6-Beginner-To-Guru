package aedev.guru.MVC.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aedev.guru.MVC.model.Beer;
import aedev.guru.MVC.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(beerId);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody Beer beer) {
        Beer saved = beerService.saveNewBeer(beer);

        log.debug(saved.getBeerName());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + saved.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @RequestBody Beer updatedBeer) {
        beerService.updateBeerById(beerId, updatedBeer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable UUID beerId) {
        beerService.deleteBeerById(beerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{beerId}")
    public ResponseEntity patchBeerById(@PathVariable UUID beerId, @RequestBody Beer updatedBeer) {
        beerService.patchBeerById(beerId, updatedBeer);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
