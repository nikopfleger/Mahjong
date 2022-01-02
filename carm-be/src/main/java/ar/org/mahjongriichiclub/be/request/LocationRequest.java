package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotNull;

public class LocationRequest extends GenericRequest {
	
	@NotNull
	private String name;
	
	private String address;
	
	private String onlineGame;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOnlineGame() {
		return onlineGame;
	}

	public void setOnlineGame(String onlineGame) {
		this.onlineGame = onlineGame;
	}
	
	
	
	
}
