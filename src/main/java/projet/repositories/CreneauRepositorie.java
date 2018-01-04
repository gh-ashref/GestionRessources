package projet.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet.entities.Creneau;
import projet.entities.Personne;
import projet.entities.Reservation;
import projet.entities.Ressource;

@Repository
public interface CreneauRepositorie extends JpaRepository<Creneau, Long> {

	@Query("SELECT c FROM Creneau c WHERE c.Reservation = :Reservation")
	public List<Creneau> getCreneauByReservation(@Param("Reservation") Reservation f);

	@Query("SELECT c FROM Creneau c WHERE c.Reservation.Personne = :Personne")
	public List<Creneau> getCreneauByUser(@Param("Personne") Personne p);

	
	
	@Query("SELECT c FROM Creneau c WHERE c.date =:date and c.Ressource =:Ressource and (c.heured >= :heured or c.heuref <= :heuref) ")
	public List<Creneau> getCreneauByDate(@Param("date") Date date, @Param("Ressource") Ressource r,
			@Param("heured") int heured, @Param("heuref") int heuref);

}
