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
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;

import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.generic.model.response.StatusResponse;

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
	public ResponseEntity<StatusResponse<PersonDTO>> addModifyPerson(@RequestBody @Validated PersonRequest person) throws ServiceException {
		PersonDTO personDTO = this.getBackofficeService().addModifyPerson(person);

		StatusResponse<PersonDTO> response = new StatusResponse<>(personDTO, StatusResponse.CREATED);
		return new ResponseEntity<StatusResponse<PersonDTO>>(response, HttpStatus.CREATED);
	}

	/**
	 * Agrega un país
	 * 
	 * @params country
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/country")
	public ResponseEntity<StatusResponse<CountryDTO>> addModifyCountry(@RequestBody @Validated CountryRequest country) throws ServiceException {
		
		CountryDTO countryDTO = this.getBackofficeService().addModifyCountry(country);
		
		StatusResponse<CountryDTO> response = new StatusResponse<>(countryDTO, StatusResponse.CREATED);
		return new ResponseEntity<StatusResponse<CountryDTO>>(response, HttpStatus.CREATED);
	}
	

	/**
	 * Agrega un jugador
	 * 
	 * @params player
	 * @return ResponseEntity
	 */
	@Override
	@PostMapping("/player")
	public ResponseEntity<StatusResponse<PlayerDTO>> addModifyPlayer(@RequestBody @Validated PlayerRequest player) throws ServiceException {
		PlayerDTO playerDTO = this.getBackofficeService().addModifyPlayer(player);
		
		StatusResponse<PlayerDTO> response = new StatusResponse<>(playerDTO, StatusResponse.CREATED);
		return new ResponseEntity<StatusResponse<PlayerDTO>>(response, HttpStatus.CREATED);
	}
	
	public BackofficeService getBackofficeService() {
		return backofficeService;
	}

	public void setBackofficeService(BackofficeService backofficeService) {
		this.backofficeService = backofficeService;
	}

}
