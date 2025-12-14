package aedev.guru.MVC.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import aedev.guru.MVC.model.BeerDTO;

public interface BeerService {
    Optional<BeerDTO> getBeerById(UUID id);

    List<BeerDTO> listBeers();

    BeerDTO saveNewBeer(BeerDTO BeerDTO);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO updatedBeer);

    void deleteBeerById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO patchedBeer);
}
