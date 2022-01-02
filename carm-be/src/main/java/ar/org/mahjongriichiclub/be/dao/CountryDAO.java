package ar.org.mahjongriichiclub.be.dao;


import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.model.Country;

public interface CountryDAO extends GenericDao<Country> {
	public Country findByCode(String code);
}
