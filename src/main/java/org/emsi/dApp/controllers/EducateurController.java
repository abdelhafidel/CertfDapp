package org.emsi.dApp.controllers;

import org.emsi.dApp.dao.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Educateur")
public class EducateurController {
	
	
	@Autowired
	EtudiantRepository etudiantRepository;

	/////////////////// home //////////////////////////
	
	@GetMapping(path = "/home")
	public String home() {
		
		return "educateur/HomeEducateur";
		
	}
	
	//////////////////////////////////////////////////
	
	////////////////// gestion etudiant //////////////
	
	@GetMapping(path = "/GestionEtu")
	public String gestionEtu(Model model) {
		model.addAttribute("etudiants", etudiantRepository.findAll());
		return "educateur/GestionEtudiant";
		
	}
	
	
}
