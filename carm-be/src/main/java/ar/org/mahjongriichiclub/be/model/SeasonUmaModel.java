package ar.org.mahjongriichiclub.be.model;

import javax.validation.constraints.NotNull;

public class SeasonUmaModel {

	@NotNull
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
