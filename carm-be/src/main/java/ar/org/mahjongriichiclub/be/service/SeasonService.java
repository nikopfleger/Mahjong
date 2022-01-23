package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.entity.Season;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface SeasonService extends GenericService<Season, SeasonDTO> {

	@Transactional(readOnly = true)
	public SeasonDTO findByNumber(Integer number) throws ServiceException;
}
