package org.emsi.dApp.controllers.gestionnaire;

import org.emsi.dApp.dao.GestionnaireRepository;
import org.emsi.dApp.metier.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion")
public class GestionnaireController {

	@Autowired
	GestionnaireRepository gestionnaireRepository;

	@GetMapping("/home")
	public String home() {
		return "gestionnaire/HomeGestionnaire";
	}

	@GetMapping("/cour")
	public String cour() {

		return "gestionnaire/GestionCours";

	}

	@GetMapping("/educateur")
	public String educateur() {

		return "gestionnaire/GestionEducateur";

	}

	@GetMapping("/test")
	public String test(Model model) {

		return "gestionnaire/AjouterCours";

	}

	@GetMapping("/profil")
	public String profil(Model model) {

		Gestionnaire gestionnaire = gestionnaireRepository.findByRole("gestionnaire");
		model.addAttribute("gestionnaire", gestionnaire);
		return "gestionnaire/GestionProfil";

	}

}
