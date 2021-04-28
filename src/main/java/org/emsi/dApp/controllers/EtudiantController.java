package org.emsi.dApp.controllers;

import org.emsi.dApp.dao.CertifRepository;
import org.emsi.dApp.dao.EtudiantRepository;
import org.emsi.dApp.dao.FormationRepository;
import org.emsi.dApp.metier.Etudiant;
import org.emsi.dApp.metier.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

	@Autowired
	CertifRepository certifRepository;

	@Autowired
	FormationRepository formationRepository;

	@Autowired
	EtudiantRepository etudiantRepository;

	////////////////// formation /////////////////////

	@GetMapping("/cour")
	public String cour(Model model) {
		model.addAttribute("cours", certifRepository.findAll());
		return "etudiant/CourEtudiant";
	}

	@GetMapping("/AjoutCour")
	public String ajouterCour(Model model, int idformation) {
		Formation f = formationRepository.getOne(idformation);
//		Etudiant et = etudiantRepository.getOne(idetudiant);
//		et.getFormations().add(f);
//		etudiantRepository.save(et);
		model.addAttribute("cours", certifRepository.findAll());
		return "etudiant/CourEtudiant";
	}

	/////////////////////////////////////////////////////

	////////////////// profil ///////////////////////////
	
	@GetMapping("/profil")
	public String profil(Model model) {
		model.addAttribute("etu", etudiantRepository.getOne(4));
		return "etudiant/ProfilEtudiant";
	}
	
	@PostMapping("/saveEtu")
	public String profil(Etudiant etudiant) {
		etudiantRepository.save(etudiant);
		return "redirect:/etudiant/profil";
	}
	
	//////////////////////////////////////////////////////
	
	
	/////////////////// home ////////////////////////////
	@GetMapping("/home")
	public String home(Model model) {
		
		return "etudiant/HomeEtudiant";
	}
	
	/////////////////////////////////////////////////////
}
