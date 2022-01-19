package ar.org.mahjongriichiclub.be.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Country;


/**
 * @author Niko
 *
 */
@MappedEntity(entity = Country.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDTO extends GenericDTO {
	

	private String name;
	
	private String nationality;
	
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
