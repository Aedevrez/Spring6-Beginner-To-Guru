package aedev.guru.MVC.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import aedev.guru.MVC.model.Beer;
import aedev.guru.MVC.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BasicBeerService implements BeerService{

    private Map<UUID, Beer> beerMap;

    public BasicBeerService(){
        this.beerMap = new HashMap<>();

        Beer firstBeer = Beer.builder()
                             .id(UUID.randomUUID())
                             .version(1)
                             .beerName("Lager")
                             .beerStyle(BeerStyle.LAGER)
                             .upc("1")
                             .quantityOnHand(13)
                             .price(new BigDecimal("9.99"))
                             .createDate(LocalDateTime.now())
                             .updateDate(LocalDateTime.now())
                             .build();

        Beer secondBeer = Beer.builder()
                              .id(UUID.randomUUID())
                              .version(1)
                              .beerName("Ale")
                              .beerStyle(BeerStyle.ALE)
                              .upc("2")
                              .quantityOnHand(11)
                              .price(new BigDecimal("11.99"))
                              .createDate(LocalDateTime.now())
                              .updateDate(LocalDateTime.now())
                              .build();

        Beer thirdBeer = Beer.builder()
                             .id(UUID.randomUUID())
                             .version(1)
                             .beerName("Wheat")
                             .beerStyle(BeerStyle.WHEAT)
                             .upc("1")
                             .quantityOnHand(9)
                             .price(new BigDecimal("7.99"))
                             .createDate(LocalDateTime.now())
                             .updateDate(LocalDateTime.now())
                             .build();

        beerMap.put(firstBeer.getId(), firstBeer);
        beerMap.put(secondBeer.getId(), secondBeer);
        beerMap.put(thirdBeer.getId(), thirdBeer);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id in service: " + id);

        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                           .id(UUID.randomUUID())
                           .version(beer.getVersion())
                           .beerName(beer.getBeerName())
                           .beerStyle(beer.getBeerStyle())
                           .upc(beer.getUpc())
                           .quantityOnHand(beer.getQuantityOnHand())
                           .price(beer.getPrice())
                           .createDate(LocalDateTime.now())
                           .updateDate(LocalDateTime.now())
                           .build();
        
        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;                   
    }

    @Override
    public void updateBeerById(UUID beerId, Beer updatedBeer) {
        Beer previous = beerMap.get(beerId);

        previous.setBeerName(updatedBeer.getBeerName());
        previous.setBeerStyle(updatedBeer.getBeerStyle());
        previous.setPrice(updatedBeer.getPrice());
        previous.setQuantityOnHand(updatedBeer.getQuantityOnHand());
        previous.setUpc(updatedBeer.getUpc());
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, Beer patchedBeer) {

        Beer existingBeer = beerMap.get(beerId);

        if (patchedBeer.getBeerName() != null) {
            existingBeer.setBeerName(patchedBeer.getBeerName());
        }

        if (patchedBeer.getBeerStyle() != null) {
            existingBeer.setBeerStyle(patchedBeer.getBeerStyle());
        }

        if (patchedBeer.getPrice() != null) {
            existingBeer.setPrice(patchedBeer.getPrice());
        }

        if (patchedBeer.getQuantityOnHand() != null) {
            existingBeer.setQuantityOnHand(patchedBeer.getQuantityOnHand());
        }

        if (patchedBeer.getUpc() != null) {
            existingBeer.setUpc(patchedBeer.getUpc());
        }
        
    }
    
}
