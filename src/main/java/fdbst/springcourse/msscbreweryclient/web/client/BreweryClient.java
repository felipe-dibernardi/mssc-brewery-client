package fdbst.springcourse.msscbreweryclient.web.client;

import fdbst.springcourse.msscbreweryclient.web.model.BeerDTO;
import fdbst.springcourse.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Classe BreweryClient
 * 
 * Essa classe ...
 *
 * @author Felipe Di Bernardi S Thiago
 */
@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private final RestTemplate restTemplate;

    private String apiHost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beer) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beer);
    }

    public void updateBeer(UUID id, BeerDTO beer) {
        restTemplate.put(apiHost + BEER_PATH_V1 + id, beer);
    }

    public void deleteBeer(UUID id) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + id);
    }

    public CustomerDTO getCustomerById(UUID id) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + id.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customer) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customer);
    }

    public void updateCustomer(UUID id, CustomerDTO customer) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + id.toString(), customer);
    }

    public void deleteCustomer(UUID id) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + id.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
