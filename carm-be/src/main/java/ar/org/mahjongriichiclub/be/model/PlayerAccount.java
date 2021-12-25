package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.model.AbstractPersistentObject;

@Entity
@Table(name = "PLAYER_ACCOUNT")
@SQLDelete(sql = "UPDATE PLAYER_ACCOUNT SET deleted = 1 WHERE id=?")
public class PlayerAccount extends AbstractPersistentObject {
	
	@Column(name="account_id", nullable=false)
	public String accountId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GAME_ACCOUNT", nullable= false)
	public OnlineGame gameAccount;

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
