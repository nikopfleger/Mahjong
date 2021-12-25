package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.AbstractPersistentObject;

@Entity
@Table(name="country")
@SQLDelete(sql = "UPDATE country SET deleted = 1 WHERE id=?")
public class Country extends AbstractPersistentObject {
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NATIONALITY")
	private String nationality;
	
	@Column(name="CODE")
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
