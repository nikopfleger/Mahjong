package ar.org.mahjongriichiclub.be.service;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.model.CountryModel;
import ar.org.mahjongriichiclub.be.model.LocationModel;
import ar.org.mahjongriichiclub.be.model.PersonModel;
import ar.org.mahjongriichiclub.be.model.PlayerModel;
import ar.org.mahjongriichiclub.be.model.RulesetModel;
import ar.org.mahjongriichiclub.be.model.SeasonModel;
import ar.org.mahjongriichiclub.be.model.TournamentResultsModel;
import ar.org.mahjongriichiclub.be.model.UmaModel;

/**
 * @author Niko
 *
 */
public interface BackofficeService {

	public PersonDTO addModifyPerson(PersonModel person) throws ServiceException;

	public CountryDTO addModifyCountry(CountryModel country) throws ServiceException;

	public PlayerDTO addModifyPlayer(PlayerModel player) throws ServiceException;

	public LocationDTO addModifyLocation(LocationModel location) throws ServiceException;

	public UmaDTO addModifyUma(UmaModel uma) throws ServiceException;

	public TournamentResultsDTO addModifyTourneyResult(TournamentResultsModel result) throws ServiceException;

	public SeasonDTO addModifySeason(SeasonModel season) throws ServiceException;;

	public RulesetDTO addModifyRuleset(RulesetModel ruleset) throws ServiceException;;

}
