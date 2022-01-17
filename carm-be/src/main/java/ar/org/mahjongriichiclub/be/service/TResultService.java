package ar.org.mahjongriichiclub.be.service;



import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.TournamentResults;

public interface TResultService extends GenericService<TournamentResults,TournamentResultsDTO> {

	@Transactional(readOnly = true)
	TournamentResultsDTO findByPlayerAndTournamentAndSeason(String player, String name, String seasonName);

}
