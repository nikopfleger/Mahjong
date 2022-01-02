package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Person;

/**
 * @author Niko
 *
 */
public interface PersonService extends GenericService<Person,PersonDTO> {

	@Transactional(readOnly = false)
	public void save(PersonDTO personDTO);

}
