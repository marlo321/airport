package marko.goliak.airport.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BaggageRequest {
    private Long weight;
    private Long ticketId;
}
