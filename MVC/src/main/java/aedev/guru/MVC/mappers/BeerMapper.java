package aedev.guru.MVC.mappers;

import aedev.guru.MVC.entities.Beer;
import aedev.guru.MVC.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
