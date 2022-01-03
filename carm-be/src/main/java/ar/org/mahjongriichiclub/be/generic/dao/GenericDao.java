package ar.org.mahjongriichiclub.be.generic.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericDao<E extends AbstractEntity> extends JpaRepository<E,Long> {
	
    public Optional<E> findById(Long id);

}
