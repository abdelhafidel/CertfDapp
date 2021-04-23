package org.emsi.dApp.dao;

import org.emsi.dApp.metier.Educateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface GestionnaireRepository extends JpaRepository<Educateur, Integer> {
	
	

}
