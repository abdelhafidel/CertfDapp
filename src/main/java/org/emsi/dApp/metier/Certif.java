package org.emsi.dApp.metier;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Certif {
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_Etudiant")
	private Etudiant etudiant;
	
	
	@OneToOne
	@JoinColumn(name = "id_test")
	private Test test;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCertif;
	private String name;
	private String code;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_obtien;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_exp;
	private String domaine;
	private String controleur;
	private String type;

}
