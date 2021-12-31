package ar.org.mahjongriichiclub.be.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;


@Entity
@Table(name = "player")
@SQLDelete(sql = "UPDATE player SET deleted = 1 WHERE id=?")
@MappedDTO(dto = PlayerDTO.class)
public class Player extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4280970450449600006L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", foreignKey = @ForeignKey(name = "PLAYER_PERSON_FK"))
	Person person;

	@Column(name = "NICKNAME", nullable = false)
	private String nickname;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_PLAYERACCOUNT_FK"))
	private List<PlayerAccount> playerAccounts;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_RATE_FK"))
	private List<Rate> playerRates;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "PLAYER_ID", foreignKey = @ForeignKey(name = "PLAYER_POINTS_FK"))
	private List<DanPoints> playerPoints;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
