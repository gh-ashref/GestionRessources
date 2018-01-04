package projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.entities.Personne;

@Repository
public interface  personneRepositorie  extends JpaRepository<Personne, Long> {

	 public Personne getPersonneByLogin(String login) ;
}
