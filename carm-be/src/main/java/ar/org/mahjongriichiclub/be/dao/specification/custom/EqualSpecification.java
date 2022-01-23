package ar.org.mahjongriichiclub.be.dao.specification.custom;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.org.mahjongriichiclub.be.dao.specification.EqualSearchCriteria;
import ar.org.mahjongriichiclub.be.dao.specification.GenericSpecification;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public class EqualSpecification<E extends AbstractEntity> extends GenericSpecification<E> {

	private static final long serialVersionUID = 1L;

	public EqualSpecification(EqualSearchCriteria<E> criteria) {
		super(criteria);
	}

	@Override
	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.<String>get(this.getCriteria().getKey()),
				this.getCriteria().getValue().toString());
	}

}
