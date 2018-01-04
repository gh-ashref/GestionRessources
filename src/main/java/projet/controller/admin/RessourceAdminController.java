package projet.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projet.entities.Ressource;
import projet.repositories.RessourceRepositorie;

@Controller
@RequestMapping("admin/ressource")
public class RessourceAdminController {
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
		model.setViewName("/ressources/add");
		return model;
	}

	

	/**
	 * delete Ressource
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteRessource", method = RequestMethod.GET)
	public String remove(@RequestParam(name = "id") Long id) {

		RessourceRepositorie.delete(id);

		return "redirect:/admin/ressource/list";
	}

	/**
	 * edit Ressource redirect View
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editRessourceView", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(name = "id") Long id) {

		Ressource ressource = RessourceRepositorie.findOne(id);
		model.addAttribute("ressource", ressource);

		return "/ressources/edit";
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
		return "redirect:/admin/ressource/list";
	}

}
