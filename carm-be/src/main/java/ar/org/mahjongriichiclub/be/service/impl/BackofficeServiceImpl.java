package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.service.PersonService;

@Service(value="backofficeService")
public class BackofficeServiceImpl implements BackofficeService {
	
	@Autowired
	PersonService personService;

	@Override
	public ResponseEntity<PersonResponse> addPerson(PersonDTO person) {
		PersonResponse personResponse = new PersonResponse();
		
		this.fillPersonResponse(personResponse, person);
		this.getPersonService().save(person);
		
		return new ResponseEntity<PersonResponse>(personResponse, HttpStatus.OK);
	}
	
	protected void fillPersonResponse(PersonResponse personResponse, PersonDTO person) {		
		
		CountryResponse countryResponse = new CountryResponse();
		CountryDTO countryPerson = person.getCountry();
		
		countryResponse.setName(countryPerson.getName());
		countryResponse.setCode(countryPerson.getCode());
		countryResponse.setNationality(countryPerson.getNationality());
		
		personResponse.setNames(person.getNames());
		personResponse.setSurnames(person.getSurnames());
		personResponse.setBirthday(person.getBirthday());
		personResponse.setCountry(countryResponse);	
		
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	

}
