package projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.entities.Ressource;

@Repository
public interface  RessourceRepositorie  extends JpaRepository<Ressource, Long> {

}
