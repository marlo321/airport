package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.BaggageRequest;
import marko.goliak.airport.dto.response.BaggageResponse;
import marko.goliak.airport.entity.Baggage;
import marko.goliak.airport.repository.BaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaggageService {
    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private TicketService ticketService;

    public Baggage findOne(Long id){
        return baggageRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Baggage with " + id + " not exists"));
    }

    public void save(BaggageRequest request){
        baggageRepository.save(baggageRequestToBaggage(null, request));
    }

    public void update(Long id, BaggageRequest request){
        baggageRepository.save(baggageRequestToBaggage(findOne(id), request));
    }

    public void delete(Long id){
        Baggage baggage = findOne(id);
        baggageRepository.delete(baggage);
    }

    public List<BaggageResponse> findAll(){
        return baggageRepository.findAll().stream().map(BaggageResponse::new).collect(Collectors.toList());
    }

    private Baggage baggageRequestToBaggage(Baggage baggage, BaggageRequest request){
        if (baggage == null){
            baggage = new Baggage();
        }
        baggage.setWeight(request.getWeight());
        baggage.setTicket(ticketService.findOne(request.getTicketId()));
        return baggage;
    }
}
