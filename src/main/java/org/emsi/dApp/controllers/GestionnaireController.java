package org.emsi.dApp.controllers;

import java.util.List;

import org.emsi.dApp.dao.EducateurRepository;
import org.emsi.dApp.dao.FormationRepository;
import org.emsi.dApp.dao.GestionnaireRepository;
import org.emsi.dApp.metier.Educateur;
import org.emsi.dApp.metier.Formation;
import org.emsi.dApp.metier.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion")
public class GestionnaireController {
	

	@Autowired
	GestionnaireRepository gestionnaireRepository;

	@Autowired
	EducateurRepository educateurRepository;
	
	@Autowired
	FormationRepository formationRepository;

	@GetMapping("/home")
	public String home() {
		return "gestionnaire/HomeGestionnaire";
		
	}

	
	
	
	/////////////////gestion educateur ////////////////////
	

	@GetMapping("/educateur")
	public String educateur(Model model) {
		List<Educateur> educateurs = educateurRepository.findAll();
		model.addAttribute("educateurs", educateurs);
		model.addAttribute("educateur", new Educateur());
		return "gestionnaire/GestionEducateur";

	}

	@PostMapping("/saveEducateur")
	public String saveEdu(Educateur educateur) {

		educateurRepository.save(educateur);
		return "redirect:/gestion/educateur";

	}
	
	@GetMapping("/deleteEdu")
	public String deleteEdu(int id) {
		
		educateurRepository.deleteById(id);
		return "redirect:/gestion/educateur";

	}
	
	@GetMapping("/modifyEdu")
	public String modifyEdu(int id,Model model) {
		
		Educateur edu =  educateurRepository.getOne(id);
		
		model.addAttribute("edu", edu);
		return "gestionnaire/ModifyEdu";

	}
	
	//////////////////////////////////////////////////////////
	
	///////////////// test et cour ///////////////////////////
	
	@GetMapping("/cour")
	public String cour(Model model) {		
		model.addAttribute("edus", educateurRepository.findAll());
		model.addAttribute("cours", formationRepository.findAll());
		return "gestionnaire/GestionCours";

	}
	
	@GetMapping("/saveCour")
	public String savecour(Model model,Formation formation,int idEduc) {
		formation.setEducateur(educateurRepository.getOne(idEduc));
		formationRepository.save(formation);
		return "redirect:/gestion/cour";

	}
	
	@GetMapping("/deleteCour")
	public String deletecour(int id) {
		
		formationRepository.deleteById(id);
		return "redirect:/gestion/cour";

	}

	@GetMapping("/test")
	public String test() {
		
		return "gestionnaire/AjouterCours";

	}
	
	//////////////////////////////////////////////////////////

	@GetMapping("/profil")
	public String profil(Model model) {

		Gestionnaire gestionnaire = gestionnaireRepository.getOne(1);
		model.addAttribute("gestionnaire", gestionnaire);
		return "gestionnaire/GestionProfil";

	}

	@PostMapping("/savePro")
	public String saveprofil(Gestionnaire gestionnaire) {
		gestionnaire.setIdUser(1);
		gestionnaireRepository.save(gestionnaire);
		return "redirect:/gestion/profil";
	}

}
