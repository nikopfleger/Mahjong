package ar.org.mahjongriichiclub.be.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public interface SearchCriteria<E extends AbstractEntity> {

	public boolean isOrPredicate();

	public Specification<E> getSpecification();

	public String getKey();

	public Object getValue();
}
