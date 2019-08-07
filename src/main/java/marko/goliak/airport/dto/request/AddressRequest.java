package marko.goliak.airport.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressRequest {
    @NotNull
    private String name;
    @NotNull
    private Long number;
    @NotNull
    private Long cityId;
}