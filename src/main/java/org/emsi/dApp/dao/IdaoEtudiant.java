package org.emsi.dApp.dao;

import org.emsi.dApp.metier.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IdaoEtudiant extends JpaRepository<Etudiant, Integer> {
	
	

}
