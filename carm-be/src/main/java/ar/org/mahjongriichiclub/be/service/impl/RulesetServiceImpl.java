package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.RulesetDAO;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.service.RulesetService;

@Service("rulesetServiceImpl")
public class RulesetServiceImpl extends GenericServiceImpl<Ruleset, RulesetDTO> implements RulesetService {

	@Autowired
	RulesetDAO rulesetDAO;

//	@Override
//	public RulesetDTO findFirst(RulesetModel ruleset) throws ServiceException {
//
//		Ruleset entity = null;
//
//		try {
//			GenericSpecificationBuilder<Ruleset> builder = new GenericSpecificationBuilder<>();
//
//			builder.with(new EqualSearchCriteria("chonbo", ruleset.getChonbo()));
//			Specification<Ruleset> spec = builder.build();
//
//			entity = this.getRulesetDAO().findFirst(spec);
//		} catch (Exception e) {
//			throw new ServiceException(ServiceExceptionConstants.ERROR_FINDING_RULESETS, e);
//		}
//
//		return entity != null ? toDTO(entity) : null;
//	}

	@Override
	public RulesetDTO findByName(String name) throws ServiceException {
		Ruleset ruleset = null;

		try {

			ruleset = this.getRulesetDAO().findByName(name);

		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.RULESET_DOES_NOT_EXIST, e);
		}

		return ruleset != null ? toDTO(ruleset) : null;
	}

	public RulesetDAO getRulesetDAO() {
		return rulesetDAO;
	}

	public void setRulesetDAO(RulesetDAO rulesetDAO) {
		this.rulesetDAO = rulesetDAO;
	}

}
