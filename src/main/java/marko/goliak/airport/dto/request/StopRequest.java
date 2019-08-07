package marko.goliak.airport.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class StopRequest {
    @NotNull
    private Long fromId;
    @NotNull
    private Long toId;
}
