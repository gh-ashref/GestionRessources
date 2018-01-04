package projet.controller.admin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import projet.entities.Creneau;
import projet.entities.CreneauRejete;
import projet.entities.Personne;
import projet.entities.Reservation;
import projet.entities.Ressource;
import projet.repositories.CreneauRepositorie;
import projet.repositories.RessourceRepositorie;
import projet.repositories.personneRepositorie;
import projet.repositories.reservationRepositorie;

@Controller
@RequestMapping("admin/reservation")
public class ReservationAdminController {

	@Autowired
	private reservationRepositorie reservationRepositorie;
	@Autowired
	private personneRepositorie personneRepositorie;
	@Autowired
	private RessourceRepositorie RessourceRepositorie;
	@Autowired
	private CreneauRepositorie CreneauRepositorie;
	private List<CreneauRejete> creneauRejetes = new ArrayList<>();


	/**
	 * reservation redirection to form
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping("form")
	public String newContact(Model model, HttpServletResponse response) {
		
		//model.setViewName("/reservation/Admin_add");
		List<Personne> listPersonnes = personneRepositorie.findAll();
		List<Ressource> listRessources = RessourceRepositorie.findAll();

		model.addAttribute("listRessources", listRessources);
		model.addAttribute("listPersonnes", listPersonnes);
		return "reservation/Admin_add";
	}

	/**
	 * add new reservation
	 * 
	 * @param reservation
	 * @param personne_id
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute Reservation reservation, @RequestParam(name = "personne_id") String personne_id,
			@RequestParam(name = "ressource_id") String ressource_id, @RequestParam(name = "heured") String heuredd,
			@RequestParam(name = "heuref") String heureff, @RequestParam(name = "qte") int qte) {

		Personne p = personneRepositorie.findOne(Long.parseLong(personne_id));
		Ressource r = RessourceRepositorie.findOne(Long.parseLong(ressource_id));
		Reservation re = reservationRepositorie.save(new Reservation(reservation.getFreq(),
				reservation.getDateDebutFreq(), reservation.getDateFinFreq(), p));
		int heured = toIntHeure(heuredd);
		int heuref = toIntHeure(heureff);
		creneauRejetes = new ArrayList<>();
		switch (reservation.getFreq()) {
		case 0:
			if (dispo(reservation.getDateDebutFreq(), qte, heured, heuref, r)) {
				CreneauRepositorie.save(new Creneau(re, r, heured, heuref, reservation.getDateDebutFreq(), qte));
			} else {
				int qteDispo = qteDispo(reservation.getDateDebutFreq(), qte, heured, heuref, r);
				creneauRejetes.add(
						new CreneauRejete(reservation.getDateDebutFreq(), qteDispo, reservation, r, heured, heuref));
			}

			break;
		default:
			Date d = reservation.getDateDebutFreq();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);

			while (d.compareTo(reservation.getDateFinFreq()) <= 0) {

				if (cal.getTime().getDay() != 0) {
					if (dispo((java.sql.Date) d, qte, heured, heuref, r)) {
						CreneauRepositorie.save(new Creneau(re, r, heured, heuref, d, qte));
					} else {
						int qteDispo = qteDispo(reservation.getDateDebutFreq(), qte, heured, heuref, r);
						creneauRejetes.add(new CreneauRejete(d, qteDispo, reservation, r, heured, heuref));

					}
				}
				cal.add(Calendar.DATE, reservation.getFreq());
				d = cal.getTime();
			}
			break;
		}
		for (CreneauRejete creneauRejete : creneauRejetes) {
			creneauRejete.toString();
		}
		return "redirect:/admin/reservation/list";
	}

	private int qteDispo(Date d, int qte, int heured, int heuref, Ressource r) {

		Date sqlDate = new java.sql.Date(d.getDate());
		List<Creneau> ll = CreneauRepositorie.getCreneauByDate(sqlDate, r, heured, heuref);
		int qteUtilise = 0;
		System.out.println("size list " + ll.size());
		for (Creneau c : ll) {
			// if ((c.getHeured().after(heured)) ||
			// (c.getHeuref().before(heuref))){
			qteUtilise += c.getQte();
			// }
		}

		Ressource ressource = RessourceRepositorie.findOne(r.getId());
		System.out.println("qte utilise" + qteUtilise + "   qtedispo" + (ressource.getQte() - qteUtilise));
		return ressource.getQte() - qteUtilise;

	}

	@SuppressWarnings("deprecation")
	private boolean dispo(Date d, int qte, int heured, int heuref, Ressource r) {
		Date sqlDate = d;
		List<Creneau> ll = CreneauRepositorie.getCreneauByDate(sqlDate, r, heured, heuref);
		System.out.println("size list " + ll.size());
		int qteUtilise = 0;
		for (Creneau c : ll) {
			// if ((c.getHeured().after(heured)) ||
			// (c.getHeuref().before(heuref))) {
			qteUtilise += c.getQte();
			// }
		}
		Ressource ressource = RessourceRepositorie.findOne(r.getId());
		System.out.println("qte utilise" + qteUtilise + "   qtedispo" + (ressource.getQte() - qteUtilise));
		if (ressource.getQte() - qteUtilise >= qte) {
			return true;
		} else {
			return false;
		}
	}

	private int toIntHeure(String heuredd) {
		StringTokenizer st = new StringTokenizer(heuredd, ":");
		int v1 = Integer.parseInt((String) st.nextElement());
		int v2 = Integer.parseInt((String) st.nextElement());

		return v1 * 60 + v2;
	}

	@RequestMapping("list")
	public String list(Model model) throws ParseException {
		List<Reservation> listReservation = reservationRepositorie.findAll();
		List<Creneau> listCreneaux = new ArrayList<>();
		for (Reservation r : listReservation) {
			for (Creneau c : CreneauRepositorie.getCreneauByReservation(r)) {
			
				listCreneaux.add(c);

			}

		}

		model.addAttribute("listCreneaux", listCreneaux);

		return "/reservation/Admin_list";
	}

	/**
	 * Delete Reservation By Admin
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteReservation", method = RequestMethod.GET)
	public String remove(@RequestParam(name = "id") Long id) {
		Reservation r = reservationRepositorie.findOne(id);
		reservationRepositorie.delete(id);
		reservationRepositorie.deleteCreneauxByReservation(r);
		return "redirect:/admin/reservation/list";
	}

	@RequestMapping("list2")
	@ResponseBody
	public List<HashMap> listhm(ModelAndView model, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		List<Creneau> listCreneaux = new ArrayList<>();
		

		Personne p = personneRepositorie.getPersonneByLogin(login);

		if (p.getRole().equals("ROLE_ADMIN")) {
			listCreneaux = CreneauRepositorie.findAll();
		} else {
			listCreneaux = CreneauRepositorie.getCreneauByUser(p);
		}

		List<HashMap> lsth = new ArrayList<>();

		for (Creneau r : listCreneaux) {
			HashMap<String, String> map = new HashMap<String, String>();
			String date = r.getDate().toString().substring(0, 11);
			map.put("title", r.getRessource().getLibelle() + "&&" + r.getQte());
			map.put("start", date + r.intToString(r.getHeured()));
			map.put("end", date + r.intToString(r.getHeuref()));

			lsth.add(map);

		}

		return lsth;
	}

	
	@RequestMapping("calender")
	public String calender(Model model, HttpServletResponse response) {
		

		return "reservation/Admin_calender";
	}
	
}