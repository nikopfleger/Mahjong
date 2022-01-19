package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.SeasonDAO;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Season;
import ar.org.mahjongriichiclub.be.service.SeasonService;

@Service("seasonServiceImpl")
public class SeasonServiceImpl extends GenericServiceImpl<Season, SeasonDTO> implements SeasonService {


	@Autowired
	private SeasonDAO seasonDAO;
	
	@Override
	public SeasonDTO findByNumber(Integer number) throws ServiceException {
		Season season = null;
		
		try {
			season = this.getSeasonDAO().findByNumber(number);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.SEASON_DOES_NOT_EXIST, new String[] { number.toString() } ,e);
		}
 		
		return this.toDTO(season);
	}

	public SeasonDAO getSeasonDAO() {
		return seasonDAO;
	}

	public void setSeasonDAO(SeasonDAO seasonDAO) {
		this.seasonDAO = seasonDAO;
	}

}
