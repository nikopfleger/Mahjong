package ar.org.mahjongriichiclub.be.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public class GenericSpecification<E extends AbstractEntity> implements Specification<E> {

	private static final long serialVersionUID = 1L;
	
	private SearchCriteria criteria;
	
	

	public GenericSpecification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}


	@Override
	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.EQUAL_COMPARATOR)) {
			return criteriaBuilder.equal(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.NOT_EQUAL_COMPARATOR)) {
			return criteriaBuilder.notEqual(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.GREATER_OR_EQUAL_COMPARATOR)) {
			return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.LESSER_OR_EQUAL_COMPARATOR)) {
			return criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getKey()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.LIKE_COMPARATOR)) {
			if (root.get(criteria.getKey()).getJavaType() == String.class) {
				return criteriaBuilder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
			} else {
				return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
			}
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.LESSER_COMPARATOR)) {
			return criteriaBuilder.lessThan(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.GREATER_COMPARATOR)) {
			return criteriaBuilder.greaterThan(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.IN_COMPARATOR)) {
			return criteriaBuilder.in(root.<String>get(criteria.getValue().toString()));
		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.IS_NULL_COMPARATOR)) {
			return criteriaBuilder.isNull(root.<String>get(criteria.getValue().toString()));

		} else if (criteria.getOperation().equalsIgnoreCase(SearchCriteria.IS_NOT_NULL_COMPARATOR)) {
			return criteriaBuilder.isNotNull(root.<String>get(criteria.getValue().toString()));
		}
		return null;

	}

}
