package org.emsi.dApp.dao.daoImpl;

import java.util.List;
import java.util.Optional;

import org.emsi.dApp.dao.IdaoCertif;
import org.emsi.dApp.metier.Educateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public class CertifImpl implements IdaoCertif {
	
	@Autowired
	IdaoCertif repo;

	@Override
	public List<Educateur> findAll() {
		List<Educateur> educateurs =repo.findAll();
		return educateurs;
	}
	
	@Override
	public List<Educateur> findAllById(Iterable<Integer> ids) {
		List<Educateur> educateurs = repo.findAllById(ids);
		return educateurs;
	}
	
	
	@Override
	public Educateur getOne(Integer id) {
		Educateur educateur = repo.getOne(id);
		return educateur;
	}
	
	@Override
	public Optional<Educateur> findById(Integer id) {
		Optional<Educateur> educateur = repo.findById(id);
		return educateur;
	}
	
	@Override
	@Transactional
	public <S extends Educateur> S save(S entity) {
			return repo.save(entity);
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
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Educateur entity) {
		repo.delete(entity);
	}

	

	@Override
	@Transactional
	public void deleteAll() {
		repo.deleteAll();

	}
	@Override
	public void deleteAll(Iterable<? extends Educateur> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Educateur> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Educateur> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Educateur> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Educateur> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Educateur> findAll(Sort sort) {
		// not implimented
		return null;
	}


	@Override
	public <S extends Educateur> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Educateur> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Educateur> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}



	@Override
	public <S extends Educateur> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Educateur> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Educateur> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
