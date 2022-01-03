package ar.org.mahjongriichiclub.be.dao;


import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.model.Location;

public interface LocationDAO extends GenericDao<Location> {
	
	public Location findByName(String name);
	
	public Location findOneByIdAndName(Long id, String name);
}
