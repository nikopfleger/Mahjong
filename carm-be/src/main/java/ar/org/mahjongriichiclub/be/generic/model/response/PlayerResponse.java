package ar.org.mahjongriichiclub.be.generic.model.response;

public class PlayerResponse {

	private PersonResponse person;
	
	private String nickname;
	
	public PersonResponse getPerson() {
		return person;
	}

	public void setPerson(PersonResponse person) {
		this.person = person;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
