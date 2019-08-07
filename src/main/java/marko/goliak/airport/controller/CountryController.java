package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.CountryRequest;
import marko.goliak.airport.dto.response.CountryResponse;
import marko.goliak.airport.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping
    public void create(@Valid @RequestBody CountryRequest request) {
        countryService.save(request);
    }

    @GetMapping
    public List<CountryResponse> findAll() {
        return countryService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CountryRequest request) throws IOException {
        countryService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        countryService.delete(id);
    }
}
