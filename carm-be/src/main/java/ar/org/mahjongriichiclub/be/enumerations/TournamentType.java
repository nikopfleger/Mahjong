package ar.org.mahjongriichiclub.be.enumerations;

public enum TournamentType {
	MINI("Mini Torneo"), BIG("Torneo");
	
	private final String value;
	
	TournamentType (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}

	public static TournamentType getEnumNoException(String value) {
		for (TournamentType v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}
	
	public static TournamentType getEnum(String value) {
		for (TournamentType v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}
}
