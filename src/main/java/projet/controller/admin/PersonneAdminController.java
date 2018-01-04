package projet.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projet.entities.Personne;
import projet.repositories.personneRepositorie;

@Controller
@RequestMapping("admin/personne")

public class PersonneAdminController {
	
	@Autowired
	private personneRepositorie personneRepositorie;
	@RequestMapping(value = "list")
	public String list(Model model, HttpServletResponse response) {
		List<Personne> listPersonne =  personneRepositorie.findAll();
		model.addAttribute("listPersonne", listPersonne);	
		return "personne/Admin_list";
	}

	/**
	 * Redirection to form Personne
	 * @param model
	 * @return
	 */
	@RequestMapping("form")
	public ModelAndView newContact(ModelAndView model) {
		model.addObject("page", "personne/Admin_add");
		model.setViewName("personne/Admin_add");
		return model;
	}

	/**
	 * Adding New Person
	 * @param personne
	 * @return
	 */
	@RequestMapping(value = "addPersonne", method = RequestMethod.POST)
	public String add(@ModelAttribute Personne personne) {
		personne.setRole("ROLE_USER");
		personneRepositorie.save(personne);
		return "redirect:/admin/personne/list";

	}

	/**
	 * Delete Personne
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePersonne", method = RequestMethod.GET)
	public String remove(@RequestParam(name = "id") Long id) {
		personneRepositorie.delete(id);
		return "redirect:/admin/personne/list";
	}

	/**
	 * Redirection to editPersonne Form
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editPersonne", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(name = "id") Long id) {
		Personne personne = personneRepositorie.findOne(id);
		model.addAttribute("personne", personne);
		return "personne/Admin_edit";
	}

}
