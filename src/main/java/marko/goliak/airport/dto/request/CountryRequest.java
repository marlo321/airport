package marko.goliak.airport.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CountryRequest {
    @NotNull
    private String name;
}
