package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.RulesetDAO;
import ar.org.mahjongriichiclub.be.dao.specification.EqualSearchCriteria;
import ar.org.mahjongriichiclub.be.dao.specification.GenericSpecificationBuilder;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.RulesetModel;
import ar.org.mahjongriichiclub.be.service.RulesetService;

@Service("rulesetServiceImpl")
public class RulesetServiceImpl extends GenericServiceImpl<Ruleset, RulesetDTO> implements RulesetService {

	@Autowired
	RulesetDAO rulesetDAO;

	@Override
	public RulesetDTO findFirst(RulesetModel ruleset) throws ServiceException {

		Ruleset entity = null;

		try {
			GenericSpecificationBuilder<Ruleset> builder = new GenericSpecificationBuilder<>();
			
			builder.with(new EqualSearchCriteria("chonbo", ruleset.getChonbo()));
			Specification<Ruleset> spec = builder.build();

			entity = this.getRulesetDAO().findFirst(spec);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.ERROR_FINDING_RULESETS);
		}
		
		return entity != null ? toDTO(entity) : null;
	}

	public RulesetDAO getRulesetDAO() {
		return rulesetDAO;
	}

	public void setRulesetDAO(RulesetDAO rulesetDAO) {
		this.rulesetDAO = rulesetDAO;
	}



}
