package projet.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import projet.entities.Ressource;
import projet.repositories.RessourceRepositorie;

@Controller
@RequestMapping("user/ressource")
public class RessourceUserController {
	@Autowired
	private RessourceRepositorie RessourceRepositorie;

	/**
	 * Liste ressources
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
		List<Ressource> listRessource = RessourceRepositorie.findAll();
		model.addAttribute("listRessource", listRessource);

		return "/ressources/list";
	}

	/**
	 * display form page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("form")
	public ModelAndView newContact(ModelAndView model) {
		model.setViewName("/ressources/add_User");
		return model;
	}

	

	/**
	 * Save or Update Ressource
	 * 
	 * @param ressource
	 * @return
	 */
	@RequestMapping(value = "/addRessource", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Ressource ressource) {

		if (ressource.getId()==null) {
			RessourceRepositorie.save(ressource);
		} else {
			RessourceRepositorie.save(ressource);
		}
		return "redirect:/user/reservation/form";
	}

}
