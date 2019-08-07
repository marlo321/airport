package marko.goliak.airport.service;

import java.util.List;
import java.util.stream.Collectors;

import marko.goliak.airport.dto.request.StopRequest;
import marko.goliak.airport.dto.response.StopResponse;
import marko.goliak.airport.entity.Stop;
import marko.goliak.airport.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StopService {
    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private AirportService airportService;

    public Stop findOne(Long id){
        return stopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Stop with "+ id +" not exists"));
    }

    public void save(StopRequest request){
        stopRepository.save(stopRequestToStop(null,request));
    }

    public void update(Long id, StopRequest request){
        stopRepository.save(stopRequestToStop(findOne(id), request));
    }

    public void delete(Long id){
        Stop stop = findOne(id);
        stopRepository.delete(stop);
    }

    public List<StopResponse> findAll(){
        return stopRepository.findAll().stream().map(StopResponse::new).collect(Collectors.toList());
    }

    private Stop stopRequestToStop(Stop stop, StopRequest request){
        if (stop == null){
            stop = new Stop();
        }
        stop.setFrom(airportService.findOne(request.getFromId()));
        stop.setTo(airportService.findOne(request.getToId()));
        return stop;
    }
}
