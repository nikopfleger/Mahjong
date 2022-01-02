package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Location;

@MappedEntity(entity = Location.class)
public class LocationDTO extends GenericDTO {
	
	private String name;	

	private String address;

	private OnlineGame onlineGame;

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

	public OnlineGame getOnlineGame() {
		return onlineGame;
	}

	public void setOnlineGame(OnlineGame onlineGame) {
		this.onlineGame = onlineGame;
	}
	
	

}
