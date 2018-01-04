package projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet.entities.CreneauRejete;
import projet.entities.Reservation;

@Repository
public interface CreneauRejeteRepositorie extends JpaRepository<CreneauRejete, Long> {
	
	@Query("SELECT c FROM CreneauRejete c WHERE c.reservation = :Reservation")
	public List<CreneauRejete> getCreneauRejeteByReservation(@Param("Reservation") Reservation f);


}
