package org.emsi.dApp.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Test {
	
	@OneToOne(mappedBy = "test")
	private Certif Certif;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinTable(name = "etudiant_test",
				joinColumns = @JoinColumn(name ="id_test"),
				inverseJoinColumns = @JoinColumn(name="id_etudiant"))
	private List<Etudiant> etudiants;
	
	@OneToOne(mappedBy = "test")
	private Formation formation;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTest;
	private String type;
	private String score;
	private Date date_test;
	

}
