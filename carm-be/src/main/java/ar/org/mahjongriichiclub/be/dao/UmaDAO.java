package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.entity.Uma;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface UmaDAO extends GenericDao<Uma> {

	public Uma findOneByIdAndName(Long id, String name);

	public Uma findByName(String name);
}
