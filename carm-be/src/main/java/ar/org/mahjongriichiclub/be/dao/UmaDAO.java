package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.model.Uma;

public interface UmaDAO extends GenericDao<Uma> {

	public Uma findOneByIdAndName(Long id, String name);

	public Uma findByName(String name);
}
