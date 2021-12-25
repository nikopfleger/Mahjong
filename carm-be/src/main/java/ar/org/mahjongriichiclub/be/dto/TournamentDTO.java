package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;
import java.util.List;


import ar.org.mahjongriichiclub.be.enumerations.TournamentType;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Tournament;


public class TournamentDTO extends GenericDTO<Tournament> { 

	private TournamentType type;
	
	private Date startDate;
	
	private Date endDate;	
	
	private SeasonDTO season;	

	private List<TournamentResultsDTO> results;

	public TournamentType getType() {
		return type;
	}

	public void setType(TournamentType type) {
		this.type = type;
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

	public SeasonDTO getSeason() {
		return season;
	}

	public void setSeason(SeasonDTO season) {
		this.season = season;
	}

	public List<TournamentResultsDTO> getResults() {
		return results;
	}

	public void setResults(List<TournamentResultsDTO> results) {
		this.results = results;
	}
	
	
}
