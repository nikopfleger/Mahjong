package ar.org.mahjongriichiclub.be.service;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.LocationRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.request.TournamentResultsRequest;
import ar.org.mahjongriichiclub.be.request.UmaRequest;

/**
 * @author Niko
 *
 */
public interface BackofficeService {

	public PersonDTO addModifyPerson(PersonRequest person) throws ServiceException;

	public CountryDTO addModifyCountry(CountryRequest country) throws ServiceException;

	public PlayerDTO addModifyPlayer(PlayerRequest player) throws ServiceException;

	public LocationDTO addModifyLocation(LocationRequest location) throws ServiceException;

	public UmaDTO addModifyUma(UmaRequest uma) throws ServiceException;

	public TournamentResultsDTO addModifyTourneyResult(TournamentResultsRequest result) throws ServiceException;


}
