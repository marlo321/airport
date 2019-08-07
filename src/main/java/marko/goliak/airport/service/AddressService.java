package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.AddressRequest;
import marko.goliak.airport.dto.response.AddressResponse;
import marko.goliak.airport.entity.Address;
import marko.goliak.airport.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CityService cityService;

    public Address findOne(Long id){
        return addressRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Address with id "+ id +" not exists"));
    }

    public void save(AddressRequest addressRequest){
        addressRepository.save(AddressRequestToAddress(null, addressRequest));
    }

    public void update(Long id, AddressRequest addressRequest){
        addressRepository.save(AddressRequestToAddress(findOne(id), addressRequest));
    }

    public List<AddressResponse> findAll(){
        return addressRepository.findAll().stream().map(AddressResponse::new).collect(Collectors.toList());
    }

    public void delete(Long id){
        Address address = findOne(id);
        addressRepository.delete(address);

    }

    private Address AddressRequestToAddress(Address address, AddressRequest addressRequest){
        if (address == null){
            address = new Address();
        }
        address.setName(addressRequest.getName());
        address.setNumber(addressRequest.getNumber());
        address.setCity(cityService.findOne(addressRequest.getCityId()));
        return address;
    }
}
