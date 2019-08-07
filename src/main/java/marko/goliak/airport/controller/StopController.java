package marko.goliak.airport.controller;

import java.util.List;
import marko.goliak.airport.dto.request.StopRequest;
import marko.goliak.airport.dto.response.StopResponse;
import marko.goliak.airport.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/stop")
public class StopController {
    @Autowired
    private StopService stopService;

    @PostMapping
    public void create(@Valid @RequestBody StopRequest request) {
        stopService.save(request);
    }

    @GetMapping
    public List<StopResponse> findAll() {
        return stopService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody StopRequest request) {
        stopService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        stopService.delete(id);
    }
}
