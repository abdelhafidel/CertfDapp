package org.emsi.dApp.dao;

import org.emsi.dApp.metier.Educateur;
import org.emsi.dApp.metier.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface GestionnaireRepository extends JpaRepository<Educateur, Integer> {
	
	@Query("select u from utilisateur u where u.role like :x")
	public Gestionnaire findByRole(@Param("x")String role);
	

}
