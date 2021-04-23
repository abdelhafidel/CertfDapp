package org.emsi.dApp.dao.daoImpl;

import java.util.List;
import java.util.Optional;

import org.emsi.dApp.dao.IdaoEtudiant;
import org.emsi.dApp.metier.Etudiant;
import org.emsi.dApp.metier.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public class EtudiantImpl implements IdaoEtudiant{
	
	@Autowired
	IdaoEtudiant repo;

	@Override
	public List<Etudiant> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Etudiant> findAllById(Iterable<Integer> ids) {
		return repo.findAllById(ids);
	}

	
	

	@Override
	public Etudiant getOne(Integer id) {
		return repo.getOne(id);
	}

	

	@Override
	@Transactional
	public <S extends Etudiant> S save(S entity) {
		return repo.save(entity);
	}

	@Override
	public Optional<Etudiant> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Etudiant entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Etudiant> entities) {
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		repo.deleteAll();
	}
	
	 ////////////////
	//other methods//
	////////////////

	@Override
	public <S extends Etudiant> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Etudiant> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Etudiant> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Etudiant> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Etudiant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Etudiant> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Etudiant> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Etudiant> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
