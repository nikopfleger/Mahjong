package ar.org.mahjongriichiclub.be.service;

import org.springframework.http.ResponseEntity;

import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.generic.model.response.PersonResponse;


public interface BackofficeService {

	ResponseEntity<PersonResponse> addPerson(PersonDTO person);

}
