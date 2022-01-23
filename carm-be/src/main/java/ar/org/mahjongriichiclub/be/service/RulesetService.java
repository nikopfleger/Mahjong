package ar.org.mahjongriichiclub.be.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.RulesetModel;

public interface RulesetService extends GenericService<Ruleset,RulesetDTO> {
	
	@Transactional(readOnly = true)
	public RulesetDTO findByName(String name) throws ServiceException;

	@Transactional(readOnly = true)
	List<RulesetDTO> findAll(RulesetModel ruleset) throws ServiceException;
}
