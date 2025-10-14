package aedev.guru.MVC;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import aedev.guru.MVC.controllers.BeerController;
import aedev.guru.MVC.model.Beer;
import aedev.guru.MVC.services.BasicBeerService;
import aedev.guru.MVC.services.BeerService;

//@SpringBootTest
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    //@Autowired
    //BeerController beerController;
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    BeerService beerService;

    BasicBeerService basicBeerService = new BasicBeerService();

    @Test
    void testGetBeerById() throws Exception{
        Beer testBeer = basicBeerService.listBeers().get(0);

        given(beerService.getBeerById(testBeer.getId())).willReturn(testBeer);

        mockMvc.perform(get("/api/v1/beer/" + testBeer.getId())
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
               .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName().toString())));
    }
}
