package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.TypeRequest;
import marko.goliak.airport.dto.response.TypeResponse;
import marko.goliak.airport.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @PostMapping
    public void create(@Valid @RequestBody TypeRequest request) {
        typeService.save(request);
    }

    @GetMapping
    public List<TypeResponse> findAll() {
        return typeService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody TypeRequest request) {
        typeService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        typeService.delete(id);
    }
}
