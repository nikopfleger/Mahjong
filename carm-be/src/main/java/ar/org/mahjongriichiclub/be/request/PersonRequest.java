package ar.org.mahjongriichiclub.be.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

public class PersonRequest {
	
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String surnames;
	
	private String countryCode;
	
	@DateTimeFormat(pattern = GenericDTO.DATE_PATTERN)
	@JsonFormat(pattern= GenericDTO.DATE_PATTERN)
	private Date birthday;
	
	@NotNull
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
