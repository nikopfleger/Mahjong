package ar.org.mahjongriichiclub.be.dao.specification;

public class EqualSearchCriteria extends SearchCriteria {

	public EqualSearchCriteria(String key, Object value, String predicate) {
		super(key, EQUAL_COMPARATOR, value, predicate);
	}

	public EqualSearchCriteria(String key, Object value) {
		super(key, EQUAL_COMPARATOR, value);
	}
}
