package aedev.guru.MVC.services;

import java.util.List;
import java.util.UUID;

import aedev.guru.MVC.model.Beer;

public interface BeerService {
    Beer getBeerById(UUID id);

    List<Beer> listBeers();

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer updatedBeer);

    void deleteBeerById(UUID beerId);

    void patchBeerById(UUID beerId, Beer patchedBeer);
}
