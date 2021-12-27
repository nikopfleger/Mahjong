package ar.org.mahjongriichiclub.be.controller;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;

public interface BackofficeController {

	public ResponseEntity<PersonResponse> addPerson(PersonDTO person);
	
	public ResponseEntity<CountryResponse> addCountry(CountryDTO country);

}
