package ar.org.mahjongriichiclub.be.controller;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.StatusResponse;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.LocationRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.request.SeasonRequest;
import ar.org.mahjongriichiclub.be.request.TournamentResultsRequest;
import ar.org.mahjongriichiclub.be.request.UmaRequest;

public interface BackofficeController {

	public ResponseEntity<StatusResponse<PersonDTO>> addModifyPerson(PersonRequest person) throws ServiceException;
	
	public ResponseEntity<StatusResponse<CountryDTO>> addModifyCountry(CountryRequest country) throws ServiceException;
	
	public ResponseEntity<StatusResponse<PlayerDTO>> addModifyPlayer(PlayerRequest player) throws ServiceException;

	public ResponseEntity<StatusResponse<LocationDTO>> addModifyLocation(LocationRequest location) throws ServiceException;
	
	public ResponseEntity<StatusResponse<UmaDTO>> addModifyLocation(UmaRequest uma) throws ServiceException;

	public ResponseEntity<StatusResponse<TournamentResultsDTO>> addModifyTourneyResult(TournamentResultsRequest result)
			throws ServiceException;

	ResponseEntity<StatusResponse<SeasonDTO>> addModifySeason(SeasonRequest result) throws ServiceException;

}
