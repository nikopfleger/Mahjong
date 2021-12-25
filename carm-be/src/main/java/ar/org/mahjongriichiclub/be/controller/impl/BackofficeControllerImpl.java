package ar.org.mahjongriichiclub.be.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.mahjongriichiclub.be.controller.BackofficeController;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.service.PersonService;

@RestController("backofficeControllerImpl")
@RequestMapping(path = "/bo")
public class BackofficeControllerImpl implements BackofficeController {

	//USAR BACKOFFICE SERVICE
	@Autowired
	PersonService personService;
	
	@Override
	@PostMapping("/person")
	public PersonDTO addPerson(@RequestBody PersonDTO person) {
		return this.getPersonService().save(person);
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	

}
