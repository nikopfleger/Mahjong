package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "LOCATION", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "name" }))
@SQLDelete(sql = "UPDATE LOCATION SET deleted = 1 WHERE id=?")
public class Location extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553515250454392026L;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "ADDRESS", unique = true)
	private String address;

	@Column(name = "ONLINE", unique = true)
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
