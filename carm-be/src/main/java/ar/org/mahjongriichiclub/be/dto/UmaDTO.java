package ar.org.mahjongriichiclub.be.dto;


import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Uma;

@MappedEntity(entity = Uma.class)
public class UmaDTO extends GenericDTO<Uma> {

	@JMap("firstPlace")
	private Integer firstPlace;
	
	@JMap("secondPlace")
	private Integer secondPlace;
	
	@JMap("thirdPlace")
	private Integer thirdPlace;
	
	@JMap("fourthPlace")
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
