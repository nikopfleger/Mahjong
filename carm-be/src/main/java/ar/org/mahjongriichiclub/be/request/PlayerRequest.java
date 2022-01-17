package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotBlank;

public class PlayerRequest {
	
	private PersonRequest person;
	
	@NotBlank
	private String nickname;

	public PersonRequest getPerson() {
		return person;
	}

	public void setPerson(PersonRequest person) {
		this.person = person;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

}
