package ar.org.mahjongriichiclub.be.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public class GenericSpecificationBuilder<E extends AbstractEntity> {
	 private final List<SearchCriteria> params;

	    public GenericSpecificationBuilder() {
	        params = new ArrayList<SearchCriteria>();
	    }
	    
	    public GenericSpecificationBuilder<E> with(SearchCriteria criteria) {
	    	params.add(criteria);
	    	return this;
	    }

	    public GenericSpecificationBuilder<E> with(String key, String operation, Object value, String predicateType) {
	        params.add(new SearchCriteria(key, operation, value, predicateType));
	        return this;
	    }
	    
	    public GenericSpecificationBuilder<E> with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }

	    public Specification<E> build() {
	        if (params.size() == 0) {
	            return null;
	        }

	        List<Specification<E>> specs = params.stream()
	          .map(GenericSpecification<E>::new)
	          .collect(Collectors.toList());
	        
	        Specification<E> result = specs.get(0);

	        for (int i = 1; i < params.size(); i++) {
	            result = params.get(i).isOrPredicate()
	                ? Specification.where(result)
	                  .or(specs.get(i))
	                : Specification.where(result)
	                  .and(specs.get(i));
	        }       
	        return result;
	    }
}
