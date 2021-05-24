package org.emsi.dApp.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data  @NoArgsConstructor @ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
public class Educateur extends Utilisateur {
	
	@OneToMany(mappedBy = "educateur",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<Formation> formations;

	private String specialite;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_Entrer;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;

	
	public Educateur(String nom, String prenom, String adresse, String username, String password, String sexe,
			Date date_nais, String email,  String specialite, Date date_Entrer) {
		super(nom, prenom, adresse, username, password, sexe, date_nais, email);
		this.specialite = specialite;
		this.date_Entrer = date_Entrer;
	}
	
	@Override
	public String role() {
		return role.getRole();
	}
	
	
	
	
}
