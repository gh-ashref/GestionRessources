package projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet.entities.Personne;
import projet.entities.Reservation;

@Repository
public interface reservationRepositorie extends JpaRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE r.Personne = :Personne")
	public List<Reservation> getReservationByPersonne(@Param("Personne") Personne p);

	@Query("delete FROM Creneau r WHERE r.Reservation = :Reservation ")
	public void deleteCreneauxByReservation(@Param("Reservation") Reservation r);
}
