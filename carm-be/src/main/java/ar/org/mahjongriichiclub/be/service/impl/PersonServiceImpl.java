package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.entity.Person;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.service.PersonService;

@Service("personServiceImpl")
public class PersonServiceImpl extends GenericServiceImpl<Person, PersonDTO> implements PersonService {


}
