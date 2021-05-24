package org.emsi.dApp.dao;

import org.emsi.dApp.metier.Certif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CertifRepository extends JpaRepository<Certif, Integer> {
	
	

}
