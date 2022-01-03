package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotNull;

public class SeasonUmaRequest extends UmaRequest {

	@NotNull
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
