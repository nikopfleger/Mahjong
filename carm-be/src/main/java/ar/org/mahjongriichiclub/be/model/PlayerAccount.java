package ar.org.mahjongriichiclub.be.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerAccountDTO;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name = "PLAYER_ACCOUNT")
@SQLDelete(sql = "UPDATE PLAYER_ACCOUNT SET deleted = 1 WHERE id=?")
@MappedDTO(dto = PlayerAccountDTO.class)
public class PlayerAccount extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3194270176022024149L;

	@Column(name="account_id", nullable=false)
	private String accountId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GAME_ACCOUNT", nullable= false)
	private OnlineGame gameAccount;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Player player;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public OnlineGame getGameAccount() {
		return gameAccount;
	}

	public void setGameAccount(OnlineGame gameAccount) {
		this.gameAccount = gameAccount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

}
