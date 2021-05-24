package org.emsi.dApp.dao;

import javax.transaction.Transactional;

import org.emsi.dApp.metier.BlockChain;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BlockchainRepository extends JpaRepository<BlockChain, Integer>{
	
	BlockChain findTopByOrderByIdBlockDesc();
}
