package aedev.guru.MVC.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import aedev.guru.MVC.model.BeerStyle;

public class Beer {
    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
