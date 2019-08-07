package marko.goliak.airport.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import marko.goliak.airport.entity.User;

import java.time.LocalDateTime;

@Getter
@Setter

public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime purchaseDataTime;

    public UserResponse(User user){
        id = user.getId();
        name = user.getName();
        lastName = user.getLastName();
        email = user.getEmail();
        purchaseDataTime = user.getPurchaseDataTime();
    }
}
