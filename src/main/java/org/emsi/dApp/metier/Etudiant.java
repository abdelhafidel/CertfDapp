package org.emsi.dApp.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString @EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur {
	
	@OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Certif> certifs;
	
	@ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<Formation> formations;
	
	@ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Test> tests;
	
	private String CNE;
	private String CIN;
	private String filiere;
	private String tele;
	private String niveau_Scolaire;
	public Etudiant(String nom, String prenom, String adresse, String username, String password, String sexe,
			Date date_nais, String email,  String cNE, String cIN, String filiere, String tele,
			String niveau_Scolaire) {
		super(nom, prenom, adresse, username, password, sexe, date_nais, email);
		
		CNE = cNE;
		CIN = cIN;
		this.filiere = filiere;
		this.tele = tele;
		this.niveau_Scolaire = niveau_Scolaire;
	}
	
	


}
