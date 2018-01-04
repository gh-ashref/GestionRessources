package projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.entities.Personne;
import projet.repositories.personneRepositorie;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private personneRepositorie personneRepositorie;
	@Autowired

	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "index")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		
		Personne p = personneRepositorie.getPersonneByLogin(login);
		if (p.getRole().equals("ROLE_ADMIN")) {
			return "redirect:/admin/personne/list";
		} else {
			return "redirect:/user/reservation/list";
		}

	}

	@RequestMapping(value = "403")
	public String NotAutho() {
		return "403";
	}

}
