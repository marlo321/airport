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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    @ManyToOne
    private Type aType;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "ticket")
    private List<Baggage> baggage = new ArrayList<>();
}
