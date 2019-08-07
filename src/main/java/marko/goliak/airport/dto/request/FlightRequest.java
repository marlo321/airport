package marko.goliak.airport.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

public class FlightRequest {

      //Take time myself
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    private LocalDate dateArrive;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
//    private LocalTime timeArrive;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    private LocalDate dateDeparture;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
//    private LocalTime timeDeparture;
    @NotNull
    private Long startAirportId;
    @NotNull
    private Long finishAirportId;
    @NotNull
    private Long statusId;
    private List<Long> stopIds = new ArrayList<>();
}
