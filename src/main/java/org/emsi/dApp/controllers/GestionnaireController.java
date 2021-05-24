package org.emsi.dApp.controllers;

import java.util.Date;
import java.util.List;

import org.emsi.dApp.Util.Block;
import org.emsi.dApp.dao.BlockchainRepository;
import org.emsi.dApp.dao.CertifRepository;
import org.emsi.dApp.dao.EducateurRepository;
import org.emsi.dApp.dao.FormationRepository;
import org.emsi.dApp.dao.GestionnaireRepository;
import org.emsi.dApp.metier.BlockChain;
import org.emsi.dApp.metier.Certif;
import org.emsi.dApp.metier.Educateur;
import org.emsi.dApp.metier.Formation;
import org.emsi.dApp.metier.Gestionnaire;
import org.emsi.dApp.metier.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	CertifRepository certifRepository;

	@Autowired
	BlockchainRepository blockchainRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
 
	
	@GetMapping("/home")
	public String home() {
		return "gestionnaire/HomeGestionnaire";

	}

	///////////////// gestion educateur ////////////////////

	@GetMapping("/educateur")
	public String educateur(Model model) {
		List<Educateur> educateurs = educateurRepository.findAll();
		model.addAttribute("educateurs", educateurs);
		model.addAttribute("educateur", new Educateur());
		return "gestionnaire/GestionEducateur";

	}

	@PostMapping("/saveEducateur")
	public String saveEdu(Educateur educateur) {
		String pwd = passwordEncoder.encode(educateur.getPassword());
		Role r = new Role();
		r.setRole("educateur");
		educateur.setPassword(pwd);
		educateur.setRole(r);
		educateurRepository.save(educateur);
		return "redirect:/gestion/educateur";

	}

	@GetMapping("/deleteEdu")
	public String deleteEdu(int id) {

		educateurRepository.deleteById(id);
		return "redirect:/gestion/educateur";

	}

	@GetMapping("/modifyEdu")
	public String modifyEdu(int id, Model model) {

		Educateur edu = educateurRepository.getOne(id);

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
	public String savecour(Model model, Formation formation, int idEduc) {
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

		model.addAttribute("gestionnaire", new Gestionnaire());
		return "gestionnaire/GestionProfil";

	}

	@PostMapping("/savePro")
	public String saveprofil(Gestionnaire gestionnaire) {
		String pwd = passwordEncoder.encode(gestionnaire.getPassword());
		Role r = new Role();
		r.setRole("admin");
		gestionnaire.setRole(r);
		gestionnaire.setPassword(pwd);
		System.out.println(pwd);
		gestionnaireRepository.save(gestionnaire);
		return "redirect:/gestion/profil";
	}
	///////////////////////////////////////////////////////////

	/////////////////// data minage ///////////////////////////

	@GetMapping(value = "/minage")
	public String DataM(Model model) {
		model.addAttribute("certifs", certifRepository.findAll());
		model.addAttribute("newblock", new BlockChain());
		return "gestionnaire/DataMinage";
	}

	@GetMapping(value = "createBlock")
	public String Cblock(Model model, int idCertif) {
			
		Certif c = certifRepository.getOne(idCertif);
		BlockChain prvBlock = blockchainRepository.findTopByOrderByIdBlockDesc();
//		Block block=new Block(prvBlock.getIdBlock()+1, c, prvBlock.getHash(), new Date().getTime());
			
//			System.out.println(block.calculateBlockHash());
//			block.setHash(block.calculateBlockHash());
//			if (block.isValidNewBlock(prvBlock)) {
//				String hPow = block.mineBlock(5);
//				block.setHash(hPow);
//
//				BlockChain b = new BlockChain();
//				b.setCertif(c);
//				b.setHash(block.getHash());
//				b.setPreviousHash(block.getPreviousHash());
//				
//				blockchainRepository.save(b);
//				
//				model.addAttribute("newblock", b);
//			}else {
//				System.out.println("problem block !!!!!!!!!!");
//			}
			
			return "redirect:/gestion/minage";

		}

	///////////////////////////////////////////////////////////

}
