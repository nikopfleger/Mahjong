package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.RulesetModel;

public interface RulesetService extends GenericService<Ruleset,RulesetDTO> {

	@Transactional(readOnly = true)
	public RulesetDTO findFirst(RulesetModel ruleset);
}
