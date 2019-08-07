package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.AddressRequest;
import marko.goliak.airport.dto.response.AddressResponse;
import marko.goliak.airport.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public void create(@Valid @RequestBody AddressRequest addressRequest){
        addressService.save(addressRequest);
    }

    @GetMapping
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody AddressRequest request){
        addressService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        addressService.delete(id);
    }
}
