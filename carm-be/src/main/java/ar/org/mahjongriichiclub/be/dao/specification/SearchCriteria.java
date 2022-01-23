package ar.org.mahjongriichiclub.be.dao.specification;

public class SearchCriteria {
	private String key;
	private String operation;
	private Object value;
	private String predicateType;
	
	public static final String EQUAL_COMPARATOR = "=";
	public static final String NOT_EQUAL_COMPARATOR = "!=";
	public static final String GREATER_OR_EQUAL_COMPARATOR = ">=";
	public static final String LESSER_OR_EQUAL_COMPARATOR = "<=";
	public static final String GREATER_COMPARATOR = ">";
	public static final String LESSER_COMPARATOR = "<";
	public static final String LIKE_COMPARATOR = ":";
	public static final String IN_COMPARATOR = "in";
	public static final String IS_NULL_COMPARATOR = "is NULL";
	public static final String IS_NOT_NULL_COMPARATOR = "is not NULL";
	public static final String OR_PREDICATE = "OR";
	public static final String AND_PREDICATE = "AND";
	
	

	public SearchCriteria(String key, String operation, Object value, String predicateType) {
		super();
		this.predicateType = predicateType;
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public SearchCriteria(String key, String operation, Object value) {
		super();
		this.predicateType = null;
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getPredicateType() {
		return predicateType;
	}

	public void setPredicateType(String predicateType) {
		this.predicateType = predicateType;
	}
	

	public boolean isOrPredicate() {
		return OR_PREDICATE.equalsIgnoreCase(predicateType);
	}
}
