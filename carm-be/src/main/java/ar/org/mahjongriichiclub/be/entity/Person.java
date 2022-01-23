package ar.org.mahjongriichiclub.be.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name = "person")
@SQLDelete(sql = "UPDATE person SET deleted = 1 WHERE id=?")
public class Person extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -455194059427307438L;

	@Column(name = "ALL_NAMES")
	private String name;

	@Column(name = "SURNAMES")
	private String surnames;

	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthday;

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
