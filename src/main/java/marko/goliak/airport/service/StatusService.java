package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.StatusRequest;
import marko.goliak.airport.dto.response.StatusResponse;
import marko.goliak.airport.entity.Status;
import marko.goliak.airport.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public Status findOne(Long id){
        return statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Status with id" + id + " not exists"));
    }

    public void save(StatusRequest statusRequest){
        statusRepository.save(statusRequestToStatus(null, statusRequest));
    }

    public void update(Long id, StatusRequest statusRequest){
        statusRepository.save(statusRequestToStatus(findOne(id), statusRequest));
    }

    public void delete(Long id){
        Status status = findOne(id);
        statusRepository.delete(status);
    }

    public List<StatusResponse> findAll(){
        return statusRepository.findAll().stream().map(StatusResponse::new).collect(Collectors.toList());
    }

    private Status statusRequestToStatus(Status status, StatusRequest request){
        if (status == null){
            status = new Status();
        }
        status.setName(request.getName());
        return status;
    }
}
