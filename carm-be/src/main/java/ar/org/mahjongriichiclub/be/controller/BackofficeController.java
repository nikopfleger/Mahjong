package ar.org.mahjongriichiclub.be.controller;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.StatusResponse;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.LocationRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;

public interface BackofficeController {

	public ResponseEntity<StatusResponse<PersonDTO>> addModifyPerson(PersonRequest person) throws ServiceException;
	
	public ResponseEntity<StatusResponse<CountryDTO>> addModifyCountry(CountryRequest country) throws ServiceException;
	
	public ResponseEntity<StatusResponse<PlayerDTO>> addModifyPlayer(PlayerRequest player) throws ServiceException;

	public ResponseEntity<StatusResponse<LocationDTO>> addModifyLocation(LocationRequest location) throws ServiceException;




}
