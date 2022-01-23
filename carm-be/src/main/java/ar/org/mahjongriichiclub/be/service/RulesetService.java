package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface RulesetService extends GenericService<Ruleset,RulesetDTO> {
	
	@Transactional(readOnly = true)
	public RulesetDTO findByName(String name) throws ServiceException;
}
