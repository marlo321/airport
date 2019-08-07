package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Stop;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
@Setter

public class StopResponse {
    private Long id;
    private AirportResponse fromResponse;
    private AirportResponse toResponse;
    public StopResponse(Stop stop){
        id = stop.getId();
        fromResponse = new AirportResponse(stop.getFrom());
        toResponse = new AirportResponse(stop.getTo());
    }
}
