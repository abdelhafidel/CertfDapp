package org.emsi.dApp.metier;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Formation {
	
	@OneToOne
	@JoinColumn(name = "id_test")
	private Test test;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_educateur")
	private Educateur educateur;
	
	@ManyToOne
	@JoinColumn(name = "id_Gestionnaire")
	private Gestionnaire gestionnaire;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idformation;
	private String lebelle;
	private String titre;
	private Date date_debut;
	private Date date_fin;
	
	
	

}
