package ar.org.mahjongriichiclub.be.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.mahjongriichiclub.be.controller.BackofficeController;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.service.BackofficeService;

@RestController("backofficeControllerImpl")
@RequestMapping(path = "/bo")
public class BackofficeControllerImpl implements BackofficeController {

	//USAR BACKOFFICE SERVICE
	@Autowired
	BackofficeService backofficeService;
	
	@Override
	@PostMapping("/person")
	public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonDTO person) {
		
		ResponseEntity<PersonResponse> response = this.getBackofficeService().addPerson(person);
				
		return response;
	}

	public BackofficeService getBackofficeService() {
		return backofficeService;
	}

	public void setBackofficeService(BackofficeService backofficeService) {
		this.backofficeService = backofficeService;
	}



}
