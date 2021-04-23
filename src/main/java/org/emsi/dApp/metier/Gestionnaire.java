package org.emsi.dApp.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Data @EqualsAndHashCode(callSuper = true) @NoArgsConstructor
public class Gestionnaire extends Utilisateur{
	
	
	@OneToMany(mappedBy = "gestionnaire",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<Formation> formations;
		
	private String code_service;
	private Date date_Entrer;
	
	
	public Gestionnaire(String nom, String prenom, String adresse, String username, String password, String sexe,
			Date date_nais, String email, String code_service, Date date_Entrer) {
		super(nom, prenom, adresse, username, password, sexe, date_nais, email);
	
		this.code_service = code_service;
		this.date_Entrer = date_Entrer;
	}
	
	
	
	
	
}
