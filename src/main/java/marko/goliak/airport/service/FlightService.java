package marko.goliak.airport.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import marko.goliak.airport.dto.request.FlightRequest;
import marko.goliak.airport.dto.response.FlightResponse;
import marko.goliak.airport.dto.response.TicketResponse;
import marko.goliak.airport.entity.Flight;
import marko.goliak.airport.repository.FlightRepository;
import marko.goliak.airport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private StatusService statusService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private StopService stopService;

    public Flight findOne(Long id){
        return flightRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Flight with " + id + " not exists"));
    }

    public void save(FlightRequest request){
        flightRepository.save(flightRequestToFlight(null, request));
    }

    public void update(Long id, FlightRequest request){
        flightRepository.save(flightRequestToFlight(findOne(id), request));
    }

    public void delete(Long id){
        Flight flight = findOne(id);
        flightRepository.delete(flight);
    }

    public List<FlightResponse> findAll(){
        return flightRepository.findAll().stream().map(FlightResponse::new).collect(Collectors.toList());
    }

    private Flight flightRequestToFlight(Flight flight, FlightRequest request){
        if (flight == null){
            flight = new Flight();
        }
        //I must control it myself
        flight.setDateArrive(LocalDate.now(ZoneId.of("Europe/Kiev")));
        flight.setTimeArrive(LocalTime.now(ZoneId.of("Europe/Kiev")));
        flight.setDateDeparture(LocalDate.now(ZoneId.of("Europe/Kiev")));
        flight.setTimeDeparture(LocalTime.now(ZoneId.of("Europe/Kiev")));
        flight.setStartAirport(airportService.findOne(request.getStartAirportId()));
        flight.setFinishAirport(airportService.findOne(request.getFinishAirportId()));
        flight.setStatus(statusService.findOne(request.getStatusId()));
        if (request.getStopIds() != null && !request.getStopIds().isEmpty()){
            flight.setStop(request.getStopIds().stream().map(stopService::findOne).collect(Collectors.toList()));
        }
        return flight;
    }
}
