package fdbst.springcourse.msscbreweryclient.web.client;

import fdbst.springcourse.msscbreweryclient.web.model.BeerDTO;
import fdbst.springcourse.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient client;

    @Test
    void getBeerById() {
        BeerDTO beer = client.getBeerById(UUID.randomUUID());

        assertNotNull(beer);
    }

    @Test
    void saveNewBeer() {
        BeerDTO beer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .beerStyle("Lagger")
                .build();

        URI uri = client.saveNewBeer(beer);

        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDTO beer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .beerStyle("Lagger")
                .build();

        client.updateBeer(beer.getId(), beer);


    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDTO customer = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customer);
    }

    @Test
    void saveNewCustomer() {
        CustomerDTO customer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Felipe")
                .build();

        URI uri = client.saveNewCustomer(customer);

        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Felipe")
                .build();

        client.updateCustomer(customer.getId(), customer);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}