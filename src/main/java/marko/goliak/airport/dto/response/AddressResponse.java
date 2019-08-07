package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Address;

@Getter
@Setter

public class AddressResponse {
    private Long id;
    private String name;
    private Long number;
    private CityResponse cityResponse;

    public AddressResponse(Address address){
        id = address.getId();
        name = address.getName();
        number = address.getNumber();
        cityResponse = new CityResponse(address.getCity());
    }
}
