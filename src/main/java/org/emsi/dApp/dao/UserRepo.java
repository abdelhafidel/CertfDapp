package org.emsi.dApp.dao;

import org.emsi.dApp.metier.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Utilisateur, Integer> {
	
	Utilisateur findByUsername(String username);

}
