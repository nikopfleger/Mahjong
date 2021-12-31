package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Person;
import ar.org.mahjongriichiclub.be.request.PersonRequest;

@MappedEntity(entity = Person.class)
public class PersonDTO extends GenericDTO<Person> {	

	@NotBlank
	@JMap("names")
	private String names;
	
	@NotBlank
	@JMap("surnames")
	private String surnames;
	
	private CountryDTO country;	

	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern= GenericDTO.DATE_PATTERN)
	@JMap("birthday")
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
