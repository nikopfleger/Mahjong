package ar.org.mahjongriichiclub.be.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public class GenericSpecificationBuilder<E extends AbstractEntity> {
	 private final List<SearchCriteria<E>> params;

	    public GenericSpecificationBuilder() {
	        params = new ArrayList<SearchCriteria<E>>();
	    }
	    
	    public GenericSpecificationBuilder<E> with(SearchCriteria<E> criteria) {
	    	params.add(criteria);
	    	return this;
	    }

	    public Specification<E> build() {
	        if (params.size() == 0) {
	            return null;
	        }

	        List<Specification<E>> specs = params.stream()
	          .map(e -> e.getSpecification())
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
