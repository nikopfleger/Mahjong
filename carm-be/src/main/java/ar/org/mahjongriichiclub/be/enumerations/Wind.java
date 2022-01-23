package ar.org.mahjongriichiclub.be.enumerations;

public enum Wind {
	TON("East"), XIA("West"), PEI("North"), NAN("South");

	private final String value;

	Wind(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public static Wind getEnumNoException(String value) {
		for (Wind v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}

	public static Wind getEnum(String value) {
		for (Wind v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}
}
