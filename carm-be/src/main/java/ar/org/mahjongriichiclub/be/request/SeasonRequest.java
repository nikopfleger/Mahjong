package ar.org.mahjongriichiclub.be.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SeasonRequest {

	@NotNull
	private Integer number;
	
	private String name;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date startDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
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
