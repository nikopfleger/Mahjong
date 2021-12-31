package ar.org.mahjongriichiclub.be.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.CountryDAO;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Country;
import ar.org.mahjongriichiclub.be.service.CountryService;

@Service(value = "countryServiceImpl")
public class CountryServiceImpl extends GenericServiceImpl<Country, CountryDTO> implements CountryService {

	@Autowired
	private CountryDAO countryDao;

	@Override
	public CountryDTO save(CountryDTO countryDTO) {
		Country country = (Country) this.convertToEntity(new Country(), countryDTO);

		Country savedCountry = this.getCountryDao().save(country);

		return (CountryDTO) this.convertToDto(savedCountry, new CountryDTO());
	}

	@Override
	public CountryDTO findByCode(String code) {
		CountryDTO countryDTO = new CountryDTO();
		Country country;

		try {
			country = this.getCountryDao().findByCode(code);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.COUNTRY_DOES_NOT_EXIST, new String[] { code }, e);
		}
		return (CountryDTO) this.convertToDto(country, countryDTO);
	}


	public CountryDAO getCountryDao() {
		return countryDao;
	}

	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDao = countryDAO;
	}

}
