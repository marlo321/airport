package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.CountryRequest;
import marko.goliak.airport.dto.response.CountryResponse;
import marko.goliak.airport.entity.Country;
import marko.goliak.airport.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public void save(CountryRequest request){
        countryRepository.save(countryRequestToCountry(null, request));
    }

    public Country findOne(Long id){
        return countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Country with id " + id + " not exists"));
    }

    public void update(Long id, CountryRequest request){
        countryRepository.save(countryRequestToCountry(findOne(id), request));
    }

    public void delete(Long id){
        Country country = findOne(id);
        countryRepository.delete(country);
    }

    public List<CountryResponse> findAll() {
        return countryRepository.findAll().stream().map(CountryResponse::new).collect(Collectors.toList());
    }

    private Country countryRequestToCountry(Country country, CountryRequest countryRequest){
        if (country == null){
            country = new Country();
        }
        country.setName(countryRequest.getName());
        return country;
    }
}
