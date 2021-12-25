package ar.org.mahjongriichiclub.be.generic.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonResponse {
	
	private String names;
	
	private String surnames;
	
	private CountryResponse country;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthday;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public CountryResponse getCountry() {
		return country;
	}

	public void setCountry(CountryResponse country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	

}
