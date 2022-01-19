package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.model.Season;

public interface SeasonDAO extends GenericDao<Season> {

	public Season findByNumber(Integer number);
}
