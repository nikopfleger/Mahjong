package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dao.CountryDao;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Country;
import ar.org.mahjongriichiclub.be.service.CountryService;

@Service(value="countryServiceImpl")
public class CountryServiceImpl extends GenericServiceImpl<Country, CountryDTO> implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	public CountryDTO save(CountryDTO countryDTO) {
		Country person = (Country) this.convertToEntity(new Country(), countryDTO);

		this.getCountryDao().save(person);
		CountryDTO cDTO = (CountryDTO) this.convertToDto(person, new CountryDTO());
		return cDTO;
	}

	public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDAO(CountryDao countryDAO) {
		this.countryDao = countryDAO;
	}

}
