package projet.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import projet.entities.Personne;
import projet.repositories.personneRepositorie;

@Component
@SessionScope
public class UserContext {

	@Autowired
	private personneRepositorie personneRepositorie;

	private Personne personneCourante;

	public Personne getPersonneCourante() {
		if (personneCourante == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			personneCourante = personneRepositorie.getPersonneByLogin(auth.getName());
		}
		return personneCourante;
	}
}
