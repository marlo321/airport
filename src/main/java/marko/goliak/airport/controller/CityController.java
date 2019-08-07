package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.CityRequest;
import marko.goliak.airport.dto.response.CityResponse;
import marko.goliak.airport.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public void create(@Valid @RequestBody CityRequest request) {
        cityService.save(request);
    }

    @GetMapping
    public List<CityResponse> findAll() {
        return cityService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CityRequest request) {
        cityService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        cityService.delete(id);
    }

}
