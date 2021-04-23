package org.emsi.dApp.metier;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@Data @NoArgsConstructor  @ToString
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	private String nom;
	private String prenom;
	private String adresse;
	private String username;
	private String password;
	private String sexe;
	private Date date_nais;
	private String email;
	
	public Utilisateur(String nom, String prenom, String adresse, String username, String password, String sexe,
			Date date_nais, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
		this.sexe = sexe;
		this.date_nais = date_nais;
		this.email = email;
	}
	
	
	
	
}
