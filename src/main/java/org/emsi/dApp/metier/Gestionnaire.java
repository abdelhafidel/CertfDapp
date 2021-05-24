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

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Gestionnaire extends Utilisateur {

	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Formation> formations;

	private String code_service;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_Entrer;

	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;

	public Gestionnaire(String nom, String prenom, String adresse, String username, String password, String sexe,
			Date date_nais, String email, String code_service, Date date_Entrer) {
		super(nom, prenom, adresse, username, password, sexe, date_nais, email);

		this.code_service = code_service;
		this.date_Entrer = date_Entrer;
	}

	@Override
	public String role() {
		return role.getRole();
	}

}
