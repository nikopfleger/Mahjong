package ar.org.mahjongriichiclub.be.service;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PlayerResponse;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;

/**
 * @author Niko
 *
 */
public interface BackofficeService {

	public ResponseEntity<PersonResponse> addModifyPerson(PersonRequest person) throws ServiceException;

	public ResponseEntity<CountryResponse> addModifyCountry(CountryRequest country) throws ServiceException;

	public ResponseEntity<PlayerResponse> addModifyPlayer(PlayerRequest player) throws ServiceException;


}
