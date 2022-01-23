package ar.org.mahjongriichiclub.be.enumerations;

public enum OnlineGame {

	RON2("Ron 2"), TENHOU("Tenhou"), MSOUL("Mahjong Soul");

	private final String value;

	OnlineGame(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public static OnlineGame getEnumNoException(String value) {
		for (OnlineGame v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		return null;
	}

	public static OnlineGame getEnum(String value) {
		for (OnlineGame v : values())
			if (v.getValue().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}

}
