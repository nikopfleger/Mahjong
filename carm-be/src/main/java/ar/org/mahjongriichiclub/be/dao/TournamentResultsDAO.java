package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.entity.TournamentResults;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface TournamentResultsDAO extends GenericDao<TournamentResults> {

	public TournamentResults findByPlayerAndTournamentAndSeason(String player, String tournament, String season);

}
