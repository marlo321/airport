package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.CityRequest;
import marko.goliak.airport.dto.response.CityResponse;
import marko.goliak.airport.entity.City;
import marko.goliak.airport.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryService countryService;

    public City findOne(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("City with id " + id + " not exists"));
    }

    public void save(CityRequest cityRequest){cityRepository.save(cityRequestToCity(null, cityRequest));}

    public void update(Long id, CityRequest cityRequest){
        cityRepository.save(cityRequestToCity(findOne(id), cityRequest));
    }

    public void delete(Long id){
        City city = findOne(id);
        cityRepository.delete(city);
    }

    public List<CityResponse> findAll() {
        return cityRepository.findAll().stream().map(CityResponse::new).collect(Collectors.toList());
    }
    private City cityRequestToCity(City city, CityRequest cityRequest){
        if (city == null){
            city = new City();
        }
        city.setName(cityRequest.getName());
        city.setCountry(countryService.findOne(cityRequest.getCountryId()));
        return city;
    }
}