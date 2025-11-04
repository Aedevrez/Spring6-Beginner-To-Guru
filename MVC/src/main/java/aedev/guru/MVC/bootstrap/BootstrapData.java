package aedev.guru.MVC.bootstrap;

import aedev.guru.MVC.entities.Beer;
import aedev.guru.MVC.entities.Customer;
import aedev.guru.MVC.model.BeerStyle;
import aedev.guru.MVC.repositories.BeerRepository;
import aedev.guru.MVC.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer firstBeer = Beer.builder()
                    .beerName("Lager")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("1")
                    .quantityOnHand(13)
                    .price(new BigDecimal("9.99"))
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer secondBeer = Beer.builder()
                    .beerName("Ale")
                    .beerStyle(BeerStyle.ALE)
                    .upc("2")
                    .quantityOnHand(11)
                    .price(new BigDecimal("11.99"))
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer thirdBeer = Beer.builder()
                    .beerName("Wheat")
                    .beerStyle(BeerStyle.WHEAT)
                    .upc("1")
                    .quantityOnHand(9)
                    .price(new BigDecimal("7.99"))
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(Arrays.asList(firstBeer, secondBeer, thirdBeer));
        }
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
            Customer firstCustomer = Customer.builder()
                    .customerName("Hakan Kaylan")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer secondCustomer = Customer.builder()
                    .customerName("Metin Çetin")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer thirdCustomer = Customer.builder()
                    .customerName("Leyla Zehra")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(firstCustomer, secondCustomer, thirdCustomer));
        }
    }
}
