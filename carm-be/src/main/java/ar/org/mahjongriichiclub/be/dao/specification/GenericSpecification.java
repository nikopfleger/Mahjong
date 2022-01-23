package ar.org.mahjongriichiclub.be.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public abstract class GenericSpecification<E extends AbstractEntity> implements Specification<E> {

	private static final long serialVersionUID = 1L;
	
	protected SearchCriteria<E> criteria;
	
	

	public GenericSpecification(SearchCriteria<E> criteria) {
		super();
		this.criteria = criteria;
	}


	public SearchCriteria<E> getCriteria() {
		return criteria;
	}


	public void setCriteria(SearchCriteria<E> criteria) {
		this.criteria = criteria;
	}

}
