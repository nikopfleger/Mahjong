package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.PersonDAO;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Country;
import ar.org.mahjongriichiclub.be.model.Person;
import ar.org.mahjongriichiclub.be.service.CountryService;
import ar.org.mahjongriichiclub.be.service.PersonService;

@Service("personServiceImpl")
public class PersonServiceImpl extends GenericServiceImpl<Person, PersonDTO> implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private CountryService countryService;

	@Override
	public void save(PersonDTO personDTO) {

		try {
			if (personDTO.getCountry() == null) {
				CountryDTO country = this.countryService.findById(personDTO.getCountry().getId());
				personDTO.setCountry(country);
			}
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.COUNTRY_DOES_NOT_EXIST,
					new String[] { personDTO.getCountry().getName() }, e);
		}

		super.save(personDTO);
	}
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}


}
