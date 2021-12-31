package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Season;

@MappedEntity(entity = Season.class)
public class SeasonDTO extends GenericDTO<Season> {

	@JMap("number")
	private Integer number;
	
	@JMap("name")
	private String name;
	
	@JMap("startDate")
	private Date startDate;
	
	@JMap("endDate")
	private Date endDate;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
