package ar.org.mahjongriichiclub.be.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericDao<T extends AbstractEntity> extends JpaRepository<T,Long> {
	
	
}
