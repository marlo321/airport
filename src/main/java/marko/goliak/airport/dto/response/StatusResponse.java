package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Status;

@Getter
@Setter

public class StatusResponse {
    private Long id;
    private String name;

    public StatusResponse(Status status){
        id = status.getId();
        name = status.getName();
    }
}