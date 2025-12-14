package aedev.guru.MVC.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

import aedev.guru.MVC.model.BeerDTO;
import aedev.guru.MVC.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BasicBeerService implements BeerService{

    private Map<UUID, BeerDTO> beerMap;

    public BasicBeerService(){
        this.beerMap = new HashMap<>();

        BeerDTO firstBeer = BeerDTO.builder()
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

        BeerDTO secondBeer = BeerDTO.builder()
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

        BeerDTO thirdBeer = BeerDTO.builder()
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
    public List<BeerDTO> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {

        log.debug("Get BeerDTO by Id in service: " + id);

        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO BeerDTO) {
        BeerDTO savedBeer = BeerDTO.builder()
                           .id(UUID.randomUUID())
                           .version(BeerDTO.getVersion())
                           .beerName(BeerDTO.getBeerName())
                           .beerStyle(BeerDTO.getBeerStyle())
                           .upc(BeerDTO.getUpc())
                           .quantityOnHand(BeerDTO.getQuantityOnHand())
                           .price(BeerDTO.getPrice())
                           .createDate(LocalDateTime.now())
                           .updateDate(LocalDateTime.now())
                           .build();
        
        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;                   
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO updatedBeer) {
        BeerDTO previous = beerMap.get(beerId);

        previous.setBeerName(updatedBeer.getBeerName());
        previous.setBeerStyle(updatedBeer.getBeerStyle());
        previous.setPrice(updatedBeer.getPrice());
        previous.setQuantityOnHand(updatedBeer.getQuantityOnHand());
        previous.setUpc(updatedBeer.getUpc());

        return Optional.of(previous);
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO patchedBeer) {

        BeerDTO existingBeer = beerMap.get(beerId);

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
