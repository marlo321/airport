package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

public class TicketResponse {
    private Long id;
    private Long price;
    private FlightResponse flightResponse;
    private TypeResponse typeResponse;
    private UserResponse userResponse;

    public TicketResponse(Ticket ticket){
        id = ticket.getId();
        price = ticket.getPrice();
        flightResponse = new FlightResponse(ticket.getFlight());
        typeResponse = new TypeResponse(ticket.getAType());
        try {
            userResponse = new UserResponse(ticket.getUser());
        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }
}
