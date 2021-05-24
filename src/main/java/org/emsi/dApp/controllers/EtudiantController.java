package org.emsi.dApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.emsi.dApp.dao.CertifRepository;
import org.emsi.dApp.dao.EtudiantRepository;
import org.emsi.dApp.dao.FormationRepository;
import org.emsi.dApp.metier.Etudiant;
import org.emsi.dApp.metier.Formation;
import org.emsi.dApp.metier.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	@Autowired
	Role role;

	@Autowired
	PasswordEncoder passwordEncoder;

	////////////////// formation /////////////////////

	@GetMapping("/cour")
	public String cour(Model model) {
		
		model.addAttribute("cours", formationRepository.findAll());
		return "etudiant/CourEtudiant";
	}

	@GetMapping("/AjoutCour")
	public String ajouterCour(int idformation,int idEtud) {
		
			Formation f = formationRepository.getOne(idformation);
			Etudiant e = etudiantRepository.getOne(idEtud);
			List<Etudiant> ets = new ArrayList<>();
			ets.add(e);
			f.setEtudiants(ets);
			formationRepository.save(f);
		
		return "redirect:/etudiant/cour";
		
	}

	/////////////////////////////////////////////////////

	////////////////// profil ///////////////////////////
	
	@GetMapping("/profil")
	public String profil() {
		
		return "etudiant/ProfilEtudiant";
	}
	
	@PostMapping("/saveEtu")
	public String profil(Etudiant etudiant) {
		
		role.setRole("etudiant");
		etudiant.setRole(role);
		etudiant.setPassword(passwordEncoder.encode(etudiant.getPassword()));
		etudiantRepository.save(etudiant);
		return "redirect:/etudiant/profil";
		
	}
	
	//////////////////////////////////////////////////////
	
	
	/////////////////// home ////////////////////////////
	@GetMapping("/home")
	public String home() {		
		return "etudiant/HomeEtudiant";
	}
	
	/////////////////////////////////////////////////////
}
