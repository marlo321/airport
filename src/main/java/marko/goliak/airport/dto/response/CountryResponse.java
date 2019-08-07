package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Country;

@Setter
@Getter

public class CountryResponse {
    private Long id;
    private String name;

    public CountryResponse(Country country){
        id = country.getId();
        name = country.getName();
    }
}
