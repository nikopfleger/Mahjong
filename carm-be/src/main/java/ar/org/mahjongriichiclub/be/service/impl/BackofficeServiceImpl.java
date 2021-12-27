package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.CountryResponse;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;
import ar.org.mahjongriichiclub.be.service.BackofficeService;
import ar.org.mahjongriichiclub.be.service.CountryService;
import ar.org.mahjongriichiclub.be.service.PersonService;

/**
 * @author Niko
 *
 */
@Service(value = "backofficeService")
public class BackofficeServiceImpl implements BackofficeService {

	@Autowired
	PersonService personService;
	
	@Autowired
	CountryService countryService;

	/**
	 * Llama al servicio que guarda la persona
	 * 
	 * @param person
	 * @return ResponseEntity<PersonResponse>
	 * 
	 */
	@Override
	public ResponseEntity<PersonResponse> addPerson(PersonDTO person) throws ServiceException {
		PersonResponse personResponse = new PersonResponse();
		try {

			this.fillPersonResponse(personResponse, person);
			this.getPersonService().save(person);

		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_USER,
					new String[] { person.getNames() + " " + person.getSurnames() });

		}

		return new ResponseEntity<PersonResponse>(personResponse, HttpStatus.OK);
	}

	/**
	 * Llena los campos de la persona
	 * 
	 * @param personResponse
	 * @param person
	 */
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

	/**
	 * Llama al servicio que guarda el país
	 * 
	 * @param country
	 * @return ResponseEntity
	 * 
	 */
	@Override
	public ResponseEntity<CountryResponse> addCountry(CountryDTO country) {
		CountryResponse countryResponse = new CountryResponse();
		try {

			countryResponse.setName(country.getName());
			countryResponse.setCode(country.getCode());
			countryResponse.setNationality(country.getNationality());
			
			this.getCountryService().save(country);
			
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.CREATE_COUNTRY,
					new String[] { country.getName() });

		}

		return new ResponseEntity<CountryResponse>(countryResponse, HttpStatus.OK);
	}

	public PersonService getPersonService() {
		return personService;
	}

	/**
	 * @param personService
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

}
