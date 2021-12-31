package ar.org.mahjongriichiclub.be.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.mahjongriichiclub.be.controller.BackofficeController;
import ar.org.mahjongriichiclub.be.exception.ServiceException;

import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PlayerResponse;

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
	 * Agrega o modifica una persona
	 * 
	 * @params person
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/person")
	public ResponseEntity<PersonResponse> addModifyPerson(@RequestBody @Validated PersonRequest person) throws ServiceException {
		return this.getBackofficeService().addModifyPerson(person);
	}

	/**
	 * Agrega un país
	 * 
	 * @params country
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/country")
	public ResponseEntity<CountryResponse> addModifyCountry(@RequestBody @Validated CountryRequest country) throws ServiceException {
		return this.getBackofficeService().addModifyCountry(country);
	}
	

	/**
	 * Agrega un jugador
	 * 
	 * @params player
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/player")
	public ResponseEntity<PlayerResponse> addModifyPlayer(@RequestBody @Validated PlayerRequest country) throws ServiceException {
		return this.getBackofficeService().addModifyPlayer(country);
	}
	
	public BackofficeService getBackofficeService() {
		return backofficeService;
	}

	public void setBackofficeService(BackofficeService backofficeService) {
		this.backofficeService = backofficeService;
	}

}
