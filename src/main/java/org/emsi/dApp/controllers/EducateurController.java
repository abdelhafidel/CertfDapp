package org.emsi.dApp.controllers;

import org.emsi.dApp.dao.CertifRepository;
import org.emsi.dApp.dao.EducateurRepository;
import org.emsi.dApp.dao.EtudiantRepository;
import org.emsi.dApp.dao.FormationRepository;
import org.emsi.dApp.metier.Certif;
import org.emsi.dApp.metier.Educateur;
import org.emsi.dApp.metier.Etudiant;
import org.emsi.dApp.metier.Formation;
import org.emsi.dApp.metier.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Educateur")
public class EducateurController {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	FormationRepository formationRepository;

	@Autowired
	EducateurRepository educateurRepository;
	
	@Autowired
	CertifRepository certifRepository;

	/////////////////// home //////////////////////////

	@GetMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("cours", formationRepository.findAll());
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
	public String saveEtu(Etudiant etudiant) {
		String pwd = passwordEncoder.encode(etudiant.getPassword());
		etudiant.setPassword(pwd);
		Role r = new Role();
		r.setRole("etudiant");
		etudiant.setRole(r);
		etudiantRepository.save(etudiant);
		return "redirect:/Educateur/GestionEtu";

	}

	@GetMapping(value = "/deleteEtu")
	public String deleteEtu(int id) {

		etudiantRepository.deleteById(id);
		return "redirect:/Educateur/GestionEtu";

	}

	@GetMapping(value = "/modifyEtu")
	public String modifyEtu(Model model, int id) {

		model.addAttribute("etu", etudiantRepository.getOne(id));
		return "educateur/ModifyEdu";

	}

	/////////////////////////////////////////////////

	///////////////// gestion profil ////////////////

	@GetMapping(value = "/GestionProf")
	public String gestionProfil() {
		return "educateur/ProfilEducateur";
	}

	@PostMapping(value = "/savePro")
	public String saveProfil(Educateur educateur) {

		String pwd = passwordEncoder.encode(educateur.getPassword());
		educateur.setPassword(pwd);
		Role r = new Role();
		r.setRole("educateur");
		educateur.setRole(r);
		return "redirect:/Educateur/home";

	}

	///////////////////////////////////////////////////
	///////////////// gestion formation////////////////

	@GetMapping(value = "/GestionForm")
	public String formation(Model model) {
		model.addAttribute("edus", etudiantRepository.findAll());
		model.addAttribute("cours", formationRepository.findAll());
		return "educateur/GestionFormation";

	}

	@PostMapping(value = "/saveFormation")
	public String saveform(Formation formation, int idEduc) {
		formation.setEducateur(educateurRepository.getOne(idEduc));
		formationRepository.save(formation);
		return "redirect:/Educateur/GestionForm";

	}

	@GetMapping(value = "/deleteCour")
	public String deleteCour(int id) {
		formationRepository.delete(formationRepository.getOne(id));
		return "redirect:/Educateur/GestionForm";
	}

	//////////////////////////////////////////////////
	///////////////// gestion des certif ////////////

	@GetMapping(value = "/validerCertif")
	public String validerCertif(Model model, int idetud, int idform, int ideduc) {

		model.addAttribute("etudiant", etudiantRepository.getOne(idetud));

		return "educateur/CertifEducateur";
	}
	

	@PostMapping(value = "/saveCertif")
	public String saveCertif(Certif certif,int idUser) {
		
		certif.setEtudiant(etudiantRepository.getOne(idUser));
		certifRepository.save(certif);

		return "redirect:/Educateur/GestionForm";
	}

	//////////////////////////////////////////////////

}
