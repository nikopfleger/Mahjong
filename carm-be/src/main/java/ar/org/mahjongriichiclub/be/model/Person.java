package ar.org.mahjongriichiclub.be.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name="person")
@SQLDelete(sql = "UPDATE person SET deleted = 1 WHERE id=?")
public class Person extends AbstractEntity {
	

	@Column(name = "NAMES")
	private String names;
	
	@Column(name = "SURNAMES")
	private String surnames;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Country country;
	
	@Column(name = "birthday")
	@Temporal(TemporalType.DATE)
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	
	
	
	

}
