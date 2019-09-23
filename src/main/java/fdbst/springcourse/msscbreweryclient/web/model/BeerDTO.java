package fdbst.springcourse.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Classe BeerDTO
 *
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
