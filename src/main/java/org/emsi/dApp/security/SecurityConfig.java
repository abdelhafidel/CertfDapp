package org.emsi.dApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


		@Autowired
		private UserDetailsService userDetailsService;

		@Bean
		public AuthenticationProvider authProveder() {

			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(userDetailsService);
			provider.setPasswordEncoder(new BCryptPasswordEncoder());
			return provider;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.formLogin().loginPage("/login");
			http.authorizeRequests()
					.antMatchers("/css/**", "/lib/**", "/main/**", "/img/**", "/contactform/**", "/login", "/logout")
					.permitAll();
			http.authorizeRequests().antMatchers("/gestion/**").hasRole("admin");
			http.authorizeRequests().antMatchers("/Educateur/**").hasRole("educateur");
			http.authorizeRequests().anyRequest().denyAll();
			http.exceptionHandling().accessDeniedPage("/notAuthorise");
		}
	

	
//	@Configuration
//	@Order(2)
//	static class OAuth2SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			http.antMatcher("/**").authorizeRequests().antMatchers("/githubOAuth2").authenticated().anyRequest().authenticated().and()
//					.oauth2Login();
//		}
//
//	
//	}
}
