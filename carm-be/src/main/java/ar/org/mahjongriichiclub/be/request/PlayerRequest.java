package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotEmpty;

public class PlayerRequest extends GenericRequest {
	
	private PersonRequest person;
	
	@NotEmpty
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
