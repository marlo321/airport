package marko.goliak.airport.repository;

import java.util.List;
import marko.goliak.airport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("from Ticket t join t.flight f where f.id = :id")
    List<Ticket> findByTicketId(@Param("id") Long id);
}