package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dao.PersonDao;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Person;
import ar.org.mahjongriichiclub.be.service.PersonService;

@Service("personServiceImpl")
public class PersonServiceImpl extends GenericServiceImpl<Person,PersonDTO> implements PersonService {
	
	@Autowired
	private PersonDao personDAO;

	@Override
	public PersonDTO save(PersonDTO personDTO) {
		Person person = (Person) this.convertToEntity(new Person(), personDTO);
		
		this.getPersonDAO().save(person);
		PersonDTO pDTO = (PersonDTO) this.convertToDto(person, new PersonDTO());
		return pDTO;
	}

	public PersonDao getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDao personDAO) {
		this.personDAO = personDAO;
	}

}
