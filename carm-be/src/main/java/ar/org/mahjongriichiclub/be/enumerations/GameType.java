package ar.org.mahjongriichiclub.be.enumerations;

public enum GameType {
	
	CASUAL("Casual"), RANKED("Ranked");
	
	private final String value;
	
	GameType (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}

	public static GameType getEnum(String value) {
		for (GameType v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}

}
