package marko.goliak.airport.controller;



import java.util.List;
import marko.goliak.airport.dto.request.AirportRequest;
import marko.goliak.airport.dto.response.AirportResponse;
import marko.goliak.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @PostMapping
    public void create(@Valid @RequestBody AirportRequest airportRequest){
        airportService.save(airportRequest);
    }

    @GetMapping
    public List<AirportResponse> findAll(){
        return airportService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody AirportRequest request){
        airportService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        airportService.delete(id);
    }
}
