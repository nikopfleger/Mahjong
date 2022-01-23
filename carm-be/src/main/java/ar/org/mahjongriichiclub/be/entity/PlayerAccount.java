package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "PLAYER_ACCOUNT")
@SQLDelete(sql = "UPDATE PLAYER_ACCOUNT SET deleted = 1 WHERE id=?")
public class PlayerAccount extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3194270176022024149L;

	@Column(name = "account_id", nullable = false)
	private String accountId;

	@Enumerated(EnumType.STRING)
	@Column(name = "GAME_ACCOUNT", nullable = false)
	private OnlineGame gameAccount;

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

}
