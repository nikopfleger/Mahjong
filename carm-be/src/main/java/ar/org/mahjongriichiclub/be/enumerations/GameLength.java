package ar.org.mahjongriichiclub.be.enumerations;

public enum GameLength {
	
	HANCHAN("Hanchan"), TONPU("Tonpuusen");
	
	private final String value;
	
	GameLength (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}

	public static GameLength getEnumNoException(String value) {
		for (GameLength v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}
	
	public static GameLength getEnum(String value) {
		for (GameLength v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}


}
