package marko.goliak.airport.controller;

import java.util.List;
import marko.goliak.airport.dto.request.FlightRequest;
import marko.goliak.airport.dto.response.FlightResponse;
import marko.goliak.airport.dto.response.TicketResponse;
import marko.goliak.airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightsController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public void create(@Valid @RequestBody FlightRequest flightRequest){
        flightService.save(flightRequest);
    }

    @GetMapping
    public List<FlightResponse> findAll(){
        return flightService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody FlightRequest request){
        flightService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        flightService.delete(id);
    }
}