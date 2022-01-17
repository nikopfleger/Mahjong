package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;


import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Person;

@MappedEntity(entity = Person.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO extends GenericDTO {	

	private String name;
	
	private String surnames;
	
	private CountryDTO country;	

	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern= GenericDTO.DATE_PATTERN)
	private Date birthday;	
	
	private String legajo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	
	
}
