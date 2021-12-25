package ar.org.mahjongriichiclub.be.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.AbstractPersistentObject;


@Entity
@Table(name = "player")
@SQLDelete(sql = "UPDATE player SET deleted = 1 WHERE id=?")
public class Player extends AbstractPersistentObject {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", foreignKey = @ForeignKey(name = "PLAYER_PERSON_FK"))
	Person person;

	@Column(name = "LEGAJO")
	private Long legajo;

	@Column(name = "NICKNAME")
	private String nickname;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_PLAYERACCOUNT_FK"))
	private List<PlayerAccount> playerAccounts;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_RATE_FK"))
	private List<Rate> playerRates;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_POINTS_FK"))
	private List<DanPoints> playerPoints;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<PlayerAccount> getPlayerAccounts() {
		return playerAccounts;
	}

	public void setPlayerAccounts(List<PlayerAccount> playerAccounts) {
		this.playerAccounts = playerAccounts;
	}

	public List<Rate> getPlayerRates() {
		return playerRates;
	}

	public void setPlayerRates(List<Rate> playerRates) {
		this.playerRates = playerRates;
	}

	public List<DanPoints> getPlayerPoints() {
		return playerPoints;
	}

	public void setPlayerPoints(List<DanPoints> playerPoints) {
		this.playerPoints = playerPoints;
	}
	
	
}
