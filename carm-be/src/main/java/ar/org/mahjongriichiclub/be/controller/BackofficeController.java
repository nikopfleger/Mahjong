package ar.org.mahjongriichiclub.be.controller;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.StatusResponse;
import ar.org.mahjongriichiclub.be.model.CountryModel;
import ar.org.mahjongriichiclub.be.model.LocationModel;
import ar.org.mahjongriichiclub.be.model.PersonModel;
import ar.org.mahjongriichiclub.be.model.PlayerModel;
import ar.org.mahjongriichiclub.be.model.SeasonModel;
import ar.org.mahjongriichiclub.be.model.TournamentResultsModel;
import ar.org.mahjongriichiclub.be.model.UmaModel;
import ar.org.mahjongriichiclub.be.model.RulesetModel;

public interface BackofficeController {

	public ResponseEntity<StatusResponse<PersonDTO>> addModifyPerson(PersonModel person) throws ServiceException;

	public ResponseEntity<StatusResponse<CountryDTO>> addModifyCountry(CountryModel country) throws ServiceException;

	public ResponseEntity<StatusResponse<PlayerDTO>> addModifyPlayer(PlayerModel player) throws ServiceException;

	public ResponseEntity<StatusResponse<LocationDTO>> addModifyLocation(LocationModel location)
			throws ServiceException;

	public ResponseEntity<StatusResponse<UmaDTO>> addModifyUma(UmaModel uma) throws ServiceException;

	public ResponseEntity<StatusResponse<TournamentResultsDTO>> addModifyTourneyResult(TournamentResultsModel result)
			throws ServiceException;

	public ResponseEntity<StatusResponse<SeasonDTO>> addModifySeason(SeasonModel result) throws ServiceException;

	public ResponseEntity<StatusResponse<RulesetDTO>> addModifyRuleset(RulesetModel ruleset) throws ServiceException;

}
