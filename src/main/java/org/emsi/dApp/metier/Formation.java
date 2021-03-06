package org.emsi.dApp.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(name = "formation_etudiant",
				joinColumns = @JoinColumn(name="id_formation"),
				inverseJoinColumns = @JoinColumn(name="id_etudiant"))
	private List<Etudiant> etudiants;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idformation;
	private String lebelle;
	private String titre;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_debut;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_fin;
	
	
	

}
