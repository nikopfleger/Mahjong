package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.AbstractPersistentObject;

@Entity
@Table(name="UMA")
@SQLDelete(sql = "UPDATE UMA SET deleted = 1 WHERE id=?")
public class Uma extends AbstractPersistentObject {
	
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
	
	


}
