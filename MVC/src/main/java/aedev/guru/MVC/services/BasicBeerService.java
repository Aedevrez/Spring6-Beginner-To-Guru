package aedev.guru.MVC.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import aedev.guru.MVC.model.Beer;
import aedev.guru.MVC.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BasicBeerService implements BeerService{

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id in service: " + id);

        return Beer.builder()
                   .id(id)
                   .version(12)
                   .beerName("Placeholder")
                   .beerStyle(BeerStyle.LAGER)
                   .upc("dunno")
                   .quantityOnHand(13)
                   .price(new BigDecimal(9.99))
                   .createdDate(LocalDateTime.now())
                   .updateDate(LocalDateTime.now())
                   .build();
    }
    
}
