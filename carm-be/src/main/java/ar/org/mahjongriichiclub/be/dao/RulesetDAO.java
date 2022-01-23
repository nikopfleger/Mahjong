package ar.org.mahjongriichiclub.be.dao;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface RulesetDAO extends GenericDao<Ruleset> {

	public Ruleset findFirst(Specification<Ruleset> spec);


}
