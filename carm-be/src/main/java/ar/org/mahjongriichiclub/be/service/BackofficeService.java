package ar.org.mahjongriichiclub.be.service;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.request.CountryRequest;
import ar.org.mahjongriichiclub.be.request.PersonRequest;
import ar.org.mahjongriichiclub.be.request.PlayerRequest;

/**
 * @author Niko
 *
 */
public interface BackofficeService {

	public PersonDTO addModifyPerson(PersonRequest person) throws ServiceException;

	public CountryDTO addModifyCountry(CountryRequest country) throws ServiceException;

	public PlayerDTO addModifyPlayer(PlayerRequest player) throws ServiceException;


}
