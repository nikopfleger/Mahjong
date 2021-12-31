package ar.org.mahjongriichiclub.be.dto;

import javax.validation.constraints.NotBlank;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Country;


/**
 * @author Niko
 *
 */
@MappedEntity(entity = Country.class)
public class CountryDTO extends GenericDTO<Country> {
	
	
	@NotBlank
	@JMap("name")
	private String name;
	
	@NotBlank
	@JMap("nationality")
	private String nationality;
	
	@NotBlank
	@JMap("code")
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
