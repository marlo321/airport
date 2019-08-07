package marko.goliak.airport.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class UserRequest {
    @NotNull
    private String name;
    @NotNull
    private String lastName;

    private String email;
}
