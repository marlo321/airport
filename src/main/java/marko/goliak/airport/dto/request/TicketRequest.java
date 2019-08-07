package marko.goliak.airport.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class TicketRequest {
    @NotNull
    private Long price;
    @NotNull
    private Long flightId;
    @NotNull
    private Long typeId;

    private UserRequest userRequest;
}
