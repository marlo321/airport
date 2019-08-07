package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Airport;

@Getter
@Setter

public class AirportResponse {
    private Long id;
    private String name;
    private AddressResponse addressResponse;

    public AirportResponse(Airport airport){
        id = airport.getId();
        name = airport.getName();
        addressResponse = new AddressResponse(airport.getAddress());
    }
}
