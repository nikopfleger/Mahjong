package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;


import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Person;

@MappedEntity(entity = Person.class)
public class PersonDTO extends GenericDTO {	

	@NotBlank
	private String names;
	
	@NotBlank
	private String surnames;
	
	private CountryDTO country;	

	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern= GenericDTO.DATE_PATTERN)
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	
	
	
}
