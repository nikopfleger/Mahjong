package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.entity.Location;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface LocationDAO extends GenericDao<Location> {

	public Location findByName(String name);

	public Location findOneByIdAndName(Long id, String name);
}
