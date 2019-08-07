package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.TicketRequest;
import marko.goliak.airport.dto.response.TicketResponse;
import marko.goliak.airport.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public void create(@Valid @RequestBody TicketRequest request){
        ticketService.save(request);
    }

    @GetMapping
    public List<TicketResponse> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/byId")
    public List<TicketResponse> findById(Long id){return ticketService.findAllByTicketId(id).stream().map(TicketResponse::new).collect(Collectors.toList());}

    @PutMapping
    public void update(Long id, @Valid @RequestBody TicketRequest request){
        ticketService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        ticketService.delete(id);
    }

}
