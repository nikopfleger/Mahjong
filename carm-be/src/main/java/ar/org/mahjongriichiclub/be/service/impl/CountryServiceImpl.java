package ar.org.mahjongriichiclub.be.service.impl;

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
		Country savedCountry = null;
		Country country = (Country) this.convertToEntity(countryDTO);
		try {
			savedCountry = this.getCountryDao().save(country);
		} catch (Exception e) {
			throw new ServiceException("No se pudo persistir el pais",e);
		}
		

		return this.convertToDto(savedCountry);
	}

	@Override
	public CountryDTO findByCode(String code) {
		Country country;

		try {
			country = this.getCountryDao().findByCode(code);

		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.COUNTRY_DOES_NOT_EXIST, new String[] { code }, e);
		}
		return this.convertToDto(country);
	}


	public CountryDAO getCountryDao() {
		return countryDao;
	}

	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDao = countryDAO;
	}

}
