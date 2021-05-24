package org.emsi.dApp.security;

import java.util.Collection;
import java.util.Collections;
import org.emsi.dApp.metier.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipal implements UserDetails {

	private Utilisateur user;

	public UserPrincipal(Utilisateur user) {
		this.user = user;
	}
	
	
//	List<GrantedAuthority> authorities = new ArrayList<>();
//	
//	this.user.getRoleList().forEach(p -> {GrantedAuthority authority = 
//			new SimpleGrantedAuthority("ROLE_"+p);
//			authorities.add(authority);});
//	
//	return authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.role()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Utilisateur getThisUser() {
		return this.user;
	}
}
