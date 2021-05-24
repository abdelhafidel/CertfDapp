package org.emsi.dApp;

import org.emsi.dApp.Util.Block;
import org.emsi.dApp.metier.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CertfDappApplication {
	


	
	public static void main(String[] args) {
		SpringApplication.run(CertfDappApplication.class, args);
		
	}
	

	@Bean
	public Role getRole() {
		return new Role();
	}
	

}
