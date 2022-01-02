package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name = "LOCATION")
@SQLDelete(sql = "UPDATE LOCATION SET deleted = 1 WHERE id=?")
@MappedDTO(dto = LocationDTO.class)
public class Location extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553515250454392026L;

	@Column(name="NAME")
	@NotNull
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ONLINE", unique = true)
	@Enumerated(EnumType.STRING)
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
