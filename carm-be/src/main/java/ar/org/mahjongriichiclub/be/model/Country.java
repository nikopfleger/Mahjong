package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.CountryDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name="country")
@SQLDelete(sql = "UPDATE country SET deleted = 1 WHERE id=?")
@MappedDTO(dto = CountryDTO.class)
public class Country extends AbstractEntity {
	
	private static final long serialVersionUID = -6916237663098795305L;

	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="NATIONALITY", nullable=false)
	private String nationality;
	
	@Column(name="CODE", nullable=false, unique= true)
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
