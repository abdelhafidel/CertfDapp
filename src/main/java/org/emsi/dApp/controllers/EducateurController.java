package org.emsi.dApp.controllers;

import org.emsi.dApp.dao.EtudiantRepository;
import org.emsi.dApp.metier.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Educateur")
public class EducateurController {

	@Autowired
	EtudiantRepository etudiantRepository;

	/////////////////// home //////////////////////////

	@GetMapping(value = "/home")
	public String home() {

		return "educateur/HomeEducateur";

	}

	//////////////////////////////////////////////////

	////////////////// gestion etudiant //////////////

	@GetMapping(value = "/GestionEtu")
	public String gestionEtu(Model model) {

		model.addAttribute("etudiant", new Etudiant());
		model.addAttribute("etudiants", etudiantRepository.findAll());
		return "educateur/GestionEtudiant";

	}
	
	


	
	@PostMapping(value = "/saveEtudiant")
	public String saveEtu(@ModelAttribute Etudiant etudiant,Model model) {
		etudiantRepository.save(etudiant);
		return "redirect:/Educateur/GestionEtu";

	}

	@GetMapping(value = "/deleteEtu")
	public String deleteEtu(int id) {

		etudiantRepository.deleteById(id);
		return "redirect:/Educateur/GestionEtu";

	}

	@GetMapping(value = "/modifyEtu")
	public String modifyEtu(Model model,int id) {
		
		model.addAttribute("etu", etudiantRepository.getOne(id));
		return "educateur/ModifyEdu";

	}

	/////////////////////////////////////////////////
	
	///////////////// gestion profil ////////////////
	
	@GetMapping(value = "/GestionProf")
	public String gestionProfil() {
		return "educateur/ProfilEducateur";
	}
	
	

}
