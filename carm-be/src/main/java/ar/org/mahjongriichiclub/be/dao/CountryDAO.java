package ar.org.mahjongriichiclub.be.dao;


import ar.org.mahjongriichiclub.be.entity.Country;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface CountryDAO extends GenericDao<Country> {
	
	public Country findByCode(String code);

	public Country findOneByIdAndCode(Long id, String code);
	
}
