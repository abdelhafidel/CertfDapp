package org.emsi.dApp.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

	@Id
	private String role;
	
	@OneToMany(mappedBy = "role")
	private List<Gestionnaire> gestionnaires;

}
