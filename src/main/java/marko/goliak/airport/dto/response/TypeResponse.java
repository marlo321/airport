package marko.goliak.airport.dto.response;

import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.Type;

@Getter
@Setter

public class TypeResponse {
    private Long id;
    private String typeOfClass;
    public TypeResponse(Type type){
        id = type.getId();
        typeOfClass = type.getTypeOfClass();
    }
}
