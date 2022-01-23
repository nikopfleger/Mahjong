package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.entity.Season;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface SeasonDAO extends GenericDao<Season> {

	public Season findByNumber(Integer number);
}
