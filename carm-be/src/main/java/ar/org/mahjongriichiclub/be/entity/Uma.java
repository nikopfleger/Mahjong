package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;

@Entity
@Table(name="UMA", uniqueConstraints=
@UniqueConstraint(columnNames={"id", "name"}))
@SQLDelete(sql = "UPDATE UMA SET deleted = 1 WHERE id=?")
@Inheritance(strategy=InheritanceType.JOINED)
public class Uma extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8185788084639680842L;
	
	@Column(name="name", nullable = false, unique = true)
	private String name;
	
	@Column(name="first_place", nullable = false)
	private Integer firstPlace;
	
	@Column(name="second_place", nullable = false)
	private Integer secondPlace;
	
	@Column(name="third_place", nullable = false)
	private Integer thirdPlace;
	
	@Column(name="fourth_place")
	private Integer fourthPlace;

	public Integer getFirstPlace() {
		return firstPlace;
	}

	public void setFirstPlace(Integer firstPlace) {
		this.firstPlace = firstPlace;
	}

	public Integer getSecondPlace() {
		return secondPlace;
	}

	public void setSecondPlace(Integer secondPlace) {
		this.secondPlace = secondPlace;
	}

	public Integer getThirdPlace() {
		return thirdPlace;
	}

	public void setThirdPlace(Integer thirdPlace) {
		this.thirdPlace = thirdPlace;
	}

	public Integer getFourthPlace() {
		return fourthPlace;
	}

	public void setFourthPlace(Integer fourthPlace) {
		this.fourthPlace = fourthPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	


}
