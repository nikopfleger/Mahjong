package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Country;

public interface CountryService extends GenericService<Country,CountryDTO> {
	
	@Transactional(readOnly = false)
	public void save(CountryDTO country) throws ServiceException;

	@Transactional(readOnly = true)
	public CountryDTO findByCode(String code) throws ServiceException;




}
