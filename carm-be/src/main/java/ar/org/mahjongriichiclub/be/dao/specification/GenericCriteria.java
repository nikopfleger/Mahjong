package ar.org.mahjongriichiclub.be.dao.specification;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

public abstract class GenericCriteria<E extends AbstractEntity> implements SearchCriteria<E> {
	
	protected String key;
	
	protected Object value; 
	
	protected String predicate;
	
	protected String comparator;
	
	protected static final String OR_PREDICATE = "OR";
	
	public GenericCriteria(String key, Object value, String predicate, String comparator) {
		super();
		this.key = key;
		this.value = value;
		this.predicate = predicate;
		this.comparator = comparator;
	}
	
	public GenericCriteria(String key, Object value, String comparator) {
		super();
		this.key = key;
		this.value = value;
		this.predicate = null;
		this.comparator = comparator;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}

}
