package ar.org.mahjongriichiclub.be.service;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;

/**
 * @author Niko
 *
 */
public interface BackofficeService {

	public ResponseEntity<PersonResponse> addPerson(PersonDTO person) throws ServiceException;

	public ResponseEntity<CountryResponse> addCountry(CountryDTO country);
}
