package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.BaggageRequest;
import marko.goliak.airport.dto.response.BaggageResponse;
import marko.goliak.airport.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/baggage")
public class BaggageController {
    @Autowired
    BaggageService baggageService;

    @PostMapping
    public void create(@Valid @RequestBody BaggageRequest request){
        baggageService.save(request);
    }

    @GetMapping
    public List<BaggageResponse> findAll(){
        return baggageService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody BaggageRequest request){
        baggageService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        baggageService.delete(id);
    }

}
