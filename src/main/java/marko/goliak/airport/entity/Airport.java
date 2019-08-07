package marko.goliak.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "startAirport")
    private List<Flight> startFlights = new ArrayList<>();
    @OneToMany(mappedBy = "finishAirport")
    private List<Flight> finishFlights = new ArrayList<>();


    @OneToMany(mappedBy = "from")
    private List<Stop> fromStops = new ArrayList<>();
    @OneToMany(mappedBy = "to")
    private List<Stop> toStops = new ArrayList<>();
}
