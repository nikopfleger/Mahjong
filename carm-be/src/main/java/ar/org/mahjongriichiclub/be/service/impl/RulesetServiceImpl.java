package ar.org.mahjongriichiclub.be.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kodgemisi.specification.GenericSpecificationBuilder;
import com.kodgemisi.specification.RelationType;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.RulesetDAO;
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
	public List<RulesetDTO> findAll(RulesetModel ruleset) throws ServiceException {

		List<Ruleset> entities = null;

		try {
			
			Specification<Ruleset> specification = GenericSpecificationBuilder.<Ruleset>of(Ruleset.class)
					.join("uma")
	 				.equals("chonbo", ruleset.getChonbo())
	 				.equals("uma.name", ruleset.getUma(), RelationType.TO_MANY)
	 				.build();
			
			entities = this.getRulesetDAO().findAll(specification);
	

		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.ERROR_FINDING_RULESETS, e);
		}

		List<RulesetDTO> dtos = new ArrayList<>();

		for (Ruleset entity : entities) {
			dtos.add(toDTO(entity));
		}

		return dtos;
	}

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
