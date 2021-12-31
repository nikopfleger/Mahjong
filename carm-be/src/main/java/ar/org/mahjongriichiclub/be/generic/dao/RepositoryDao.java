package ar.org.mahjongriichiclub.be.generic.dao;

import org.springframework.stereotype.Repository;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Repository
public interface RepositoryDao<ENTITY extends AbstractEntity> extends GenericDao<ENTITY> {

}
