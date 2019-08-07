package marko.goliak.airport.service;

import marko.goliak.airport.dto.request.TypeRequest;
import marko.goliak.airport.dto.response.TypeResponse;
import marko.goliak.airport.entity.Type;
import marko.goliak.airport.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;

    public Type findOne(Long id){
        return typeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Type with "+id+" not exists"));
    }

    public void save(TypeRequest typeRequest){
        typeRepository.save(typeRequestToType(null, typeRequest));
    }

    public void update(Long id, TypeRequest typeRequest){
        typeRepository.save(typeRequestToType(findOne(id), typeRequest));
    }

    public void delete(Long id){
        Type type = findOne(id);
        typeRepository.delete(type);
    }

    public List<TypeResponse> findAll(){
        return typeRepository.findAll().stream().map(TypeResponse::new).collect(Collectors.toList());
    }

    private Type typeRequestToType(Type type, TypeRequest typeRequest){
        if(type == null){
            type = new Type();
        }
        type.setTypeOfClass(typeRequest.getTypeOfClass());
        return type;
    }
}
