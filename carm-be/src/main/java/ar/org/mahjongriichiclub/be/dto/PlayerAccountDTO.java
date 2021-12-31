package ar.org.mahjongriichiclub.be.dto;


import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.PlayerAccount;

@MappedEntity(entity = PlayerAccount.class)
public class PlayerAccountDTO extends GenericDTO<PlayerAccount> {

	@JMap("accountId")
	public String accountId;
	
	@JMap("gameAccount")
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
