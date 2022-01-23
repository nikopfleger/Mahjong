package ar.org.mahjongriichiclub.be.generic.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public interface GenericDao<E extends AbstractEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

	public Optional<E> findById(Long id);

}
