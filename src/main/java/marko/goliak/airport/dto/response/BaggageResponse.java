package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Baggage;

@Getter
@Setter

public class BaggageResponse {
    private Long id;
    private Long weight;
    private TicketResponse ticketResponse;

    public BaggageResponse(Baggage baggage){
        id = baggage.getId();
        weight = baggage.getWeight();
        ticketResponse = new TicketResponse(baggage.getTicket());
    }
}
