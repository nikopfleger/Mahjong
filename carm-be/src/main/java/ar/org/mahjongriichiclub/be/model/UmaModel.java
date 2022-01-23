package ar.org.mahjongriichiclub.be.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UmaModel {
	
	@NotBlank
	private String name;

	@NotNull
	private Integer firstPlace;
	
	@NotNull
	private Integer secondPlace;
	
	@NotNull
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
