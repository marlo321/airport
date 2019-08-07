package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.AirportRequest;
import marko.goliak.airport.dto.response.AirportResponse;
import marko.goliak.airport.entity.Airport;
import marko.goliak.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AddressService addressService;

    public Airport findOne(Long id){
        return airportRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Airport with id "+ id +" not exists"));
    }


    public void save(AirportRequest airportRequest){
        airportRepository.save(AirportRequestToAirport(null, airportRequest));
    }

    public void update(Long id, AirportRequest airportRequest){
        airportRepository.save(AirportRequestToAirport(findOne(id), airportRequest));
    }

    public List<AirportResponse> findAll(){
        return airportRepository.findAll().stream().map(AirportResponse::new).collect(Collectors.toList());
    }

    public void delete(Long id){
        Airport airport = findOne(id);
        airportRepository.delete(airport);
    }

    private Airport AirportRequestToAirport(Airport airport, AirportRequest airportRequest){
        if (airport == null){
            airport = new Airport();
        }
        airport.setName(airportRequest.getName());
        airport.setAddress(addressService.findOne(airportRequest.getAddressId()));
        return airport;
    }
}
