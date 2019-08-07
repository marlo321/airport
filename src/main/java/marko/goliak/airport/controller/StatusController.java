package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.StatusRequest;
import marko.goliak.airport.dto.response.StatusResponse;
import marko.goliak.airport.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping
    public void create(@Valid @RequestBody StatusRequest statusRequest){
        statusService.save(statusRequest);
    }

    @GetMapping
    public List<StatusResponse> findAll(){
        return statusService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody StatusRequest statusRequest){
        statusService.update(id, statusRequest);
    }

    @DeleteMapping
    public void delete(Long id){
        statusService.delete(id);
    }
}
