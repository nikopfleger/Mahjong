package ar.org.mahjongriichiclub.be.enumerations;

public enum GameType {

	CASUAL(Values.CASUAL), RANKED(Values.RANKED), TOURNAMENT(Values.TOURNAMENT);

	private final String value;

	GameType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public static GameType getEnumNoException(String value) {
		for (GameType v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}

	public static GameType getEnum(String value) {
		for (GameType v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}

	public static class Values {
		public static final String CASUAL = "CASUAL";
		public static final String RANKED = "RANKED";
		public static final String TOURNAMENT = "TOURNAMENT";
	}

}
