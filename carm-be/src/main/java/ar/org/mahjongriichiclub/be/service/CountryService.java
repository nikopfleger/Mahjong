package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Country;

public interface CountryService extends GenericService<Country,CountryDTO> {
	
	/**
	 * Guarda el país
	 * 
	 * @params country
	 * @return CountryDTO
	 */
	@Transactional(readOnly = false)
	public CountryDTO save(CountryDTO country);

}
