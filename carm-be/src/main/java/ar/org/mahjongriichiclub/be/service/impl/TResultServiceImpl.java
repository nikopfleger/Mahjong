package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.TournamentResultsDAO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.entity.TournamentResults;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.service.TResultService;

@Service("tResultServiceImpl")
public class TResultServiceImpl extends GenericServiceImpl<TournamentResults, TournamentResultsDTO>
		implements TResultService {

	@Autowired
	private TournamentResultsDAO tournamentResultsDAO;

	@Override
	public TournamentResultsDTO findByPlayerAndTournamentAndSeason(String player, String tournament, String season) {
		TournamentResults result = null;

		try {
			result = this.getTournamentResultsDAO().findByPlayerAndTournamentAndSeason(player, tournament, season);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.RECORD_DOES_NOT_EXIST,
					new String[] { player, tournament, season }, e);
		}
		return this.toDTO(result);
	}

	public TournamentResultsDAO getTournamentResultsDAO() {
		return tournamentResultsDAO;
	}

	public void setTournamentResultsDAO(TournamentResultsDAO tournamentResultsDAO) {
		this.tournamentResultsDAO = tournamentResultsDAO;
	}

}
