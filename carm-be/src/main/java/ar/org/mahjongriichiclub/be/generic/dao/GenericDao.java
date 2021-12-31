package ar.org.mahjongriichiclub.be.generic.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@NoRepositoryBean
public interface GenericDao<T extends AbstractEntity> extends JpaRepository<T,Long> {
	
    public Optional<T> findById(Long id);
}
