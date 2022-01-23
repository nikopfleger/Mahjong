package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.entity.Uma;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

@MappedEntity(entity = Uma.class)
public class UmaDTO extends GenericDTO {

	private String name;

	private Integer firstPlace;

	private Integer secondPlace;

	private Integer thirdPlace;

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
