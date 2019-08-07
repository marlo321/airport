package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.TicketRequest;
import marko.goliak.airport.dto.response.TicketResponse;
import marko.goliak.airport.entity.Ticket;
import marko.goliak.airport.entity.User;
import marko.goliak.airport.repository.TicketRepository;
import marko.goliak.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeService typeService;

    @Autowired
    UserService userService;

    @Autowired
    FlightService flightService;


    public List<Ticket> findAllByTicketId(Long flightId){ return ticketRepository.findByTicketId(flightId); }


    public Ticket findOne(Long id){
        return ticketRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ticket with " + id + " not exists"));
    }

    public void save(TicketRequest request){
        ticketRepository.save(ticketRequestToTicket(null, request));
    }

    public void update(Long id, TicketRequest request){
        ticketRepository.save(ticketRequestToTicket(findOne(id), request));
    }

    public void delete(Long id){
        Ticket ticket = findOne(id);
        ticketRepository.delete(ticket);
    }

    public List<TicketResponse> findAll(){
        return ticketRepository.findAll().stream().map(TicketResponse::new).collect(Collectors.toList());
    }

    private Ticket ticketRequestToTicket(Ticket ticket, TicketRequest request){
        User user = new User();
        if (ticket == null){
            ticket = new Ticket();
            user = null;
        }
        else {
            if (AllExist(request.getUserRequest().getEmail(),request.getUserRequest().getName(),request.getUserRequest().getLastName())) {
                user.setName(request.getUserRequest().getName());
                user.setLastName(request.getUserRequest().getLastName());
                user.setEmail(request.getUserRequest().getEmail());
                user.setPurchaseDataTime(LocalDateTime.now(ZoneId.of("Europe/Kiev")));
                user = userRepository.save(user);
            }
            else {
                user = null;
            }
        }
        ticket.setPrice(request.getPrice());
        ticket.setAType(typeService.findOne(request.getTypeId()));
        ticket.setFlight(flightService.findOne(request.getFlightId()));
        ticket.setUser(user);

        return ticket;
    }

    private boolean AllExist(String...args){
        for (String arg : args){
            if (arg.isEmpty()||arg==null){
                return false;
            }
        }
        return true;
    }
}
