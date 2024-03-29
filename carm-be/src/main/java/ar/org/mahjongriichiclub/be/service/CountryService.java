package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.entity.Country;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface CountryService extends GenericService<Country, CountryDTO> {

	@Transactional(readOnly = true)
	public CountryDTO findByCode(String code) throws ServiceException;

}
