package ar.org.mahjongriichiclub.be.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.mahjongriichiclub.be.controller.BackofficeController;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;

/**
 * @author Niko
 *
 */
@RestController("backofficeControllerImpl")
@RequestMapping(path = "/bo")
public class BackofficeControllerImpl implements BackofficeController {

	@Autowired
	BackofficeService backofficeService;

	/**
	 * Agrega una persona
	 * 
	 * @params person
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/person")
	public ResponseEntity<PersonResponse> addPerson(@RequestBody @Validated PersonDTO person) {

		ResponseEntity<PersonResponse> response = this.getBackofficeService().addPerson(person);

		return response;
	}

	/**
	 * Agrega un país
	 * 
	 * @params country
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/country")
	public ResponseEntity<CountryResponse> addCountry(@RequestBody @Validated CountryDTO country) {

		ResponseEntity<CountryResponse> response = this.getBackofficeService().addCountry(country);

		return response;
	}

	public BackofficeService getBackofficeService() {
		return backofficeService;
	}

	public void setBackofficeService(BackofficeService backofficeService) {
		this.backofficeService = backofficeService;
	}

}
