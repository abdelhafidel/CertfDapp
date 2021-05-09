package org.emsi.dApp.security;

import org.emsi.dApp.dao.UserRepo;
import org.emsi.dApp.metier.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user=  userRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("error 403");
		return new UserPrincipal(user);
	}

	
}
