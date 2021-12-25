package ar.org.mahjongriichiclub.be.dto;


import ar.org.mahjongriichiclub.be.enumerations.OnlineGame;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.PlayerAccount;

public class PlayerAccountDTO extends GenericDTO<PlayerAccount> {

	public String accountId;
	
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
