package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotBlank;

public class CountryRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String nationality;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
