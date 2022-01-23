package ar.org.mahjongriichiclub.be.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public class EqualSearchCriteria<E extends AbstractEntity> extends GenericCriteria<E> {

	public static final String EQUAL_COMPARATOR = "=";

	public EqualSearchCriteria(String key, Object value, String predicate) {
		super(key, value, predicate, EQUAL_COMPARATOR);
	}

	public EqualSearchCriteria(String key, Object value) {
		super(key, value, EQUAL_COMPARATOR);
	}

	@Override
	public boolean isOrPredicate() {
		return OR_PREDICATE.equals(predicate);
	}

	@Override
	public Specification<E> getSpecification() {

		Specification<E> spec = new Specification<E>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.<String>get(getKey()), getValue().toString());
			}
		};

		return spec;
	}

}
