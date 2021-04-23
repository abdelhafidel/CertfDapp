package org.emsi.dApp.controllers;

import org.emsi.dApp.dao.EducateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	private EducateurRepository educateurRepository;
	
}
