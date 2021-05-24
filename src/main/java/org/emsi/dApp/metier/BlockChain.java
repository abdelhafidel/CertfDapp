package org.emsi.dApp.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockChain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBlock;
	private String hash;
	private String previousHash;
	@OneToOne
	@JoinColumn(name = "id_certif")
	private Certif certif;

}
