package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Flight;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

@Getter
@Setter

public class FlightResponse {
    private Long id;
    private LocalDate dateArrive;
    private LocalTime timeArrive;
    private LocalDate dateDeparture;
    private LocalTime timeDeparture;
    private AirportResponse startAirportResponse;
    private AirportResponse finishAirportResponse;
    private StatusResponse statusResponse;
    private List<StopResponse> stopResponseList;

    public FlightResponse(Flight flight){
        id = flight.getId();
        dateArrive = flight.getDateArrive();
        timeArrive = flight.getTimeArrive();
        dateDeparture = flight.getDateDeparture();
        timeDeparture = flight.getTimeDeparture();
        startAirportResponse = new AirportResponse(flight.getStartAirport());
        finishAirportResponse = new AirportResponse(flight.getFinishAirport());
        statusResponse = new StatusResponse(flight.getStatus());
        stopResponseList = flight.getStop().stream().map(StopResponse::new).collect(Collectors.toList());
    }
}
