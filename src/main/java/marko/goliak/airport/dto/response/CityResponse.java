package marko.goliak.airport.dto.response;


import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.City;

@Getter
@Setter

public class CityResponse {
    private Long id;
    private String name;
    private CountryResponse countryResponse;

    public CityResponse(City city){
        id = city.getId();
        name = city.getName();
        countryResponse = new CountryResponse(city.getCountry());
    }
}
