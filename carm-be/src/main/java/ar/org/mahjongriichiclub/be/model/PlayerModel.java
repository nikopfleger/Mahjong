package ar.org.mahjongriichiclub.be.model;

import java.util.Hashtable;

import javax.validation.constraints.NotBlank;

public class PlayerModel {
	
	private PersonModel person;
	
	@NotBlank
	private String nickname;	

	private Hashtable<String,String> onlineAccounts;
	
	public Hashtable<String, String> getOnlineAccounts() {
		return onlineAccounts;
	}

	public void setOnlineAccounts(Hashtable<String, String> onlineAccounts) {
		this.onlineAccounts = onlineAccounts;
	}

	public PersonModel getPerson() {
		return person;
	}

	public void setPerson(PersonModel person) {
		this.person = person;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

}
