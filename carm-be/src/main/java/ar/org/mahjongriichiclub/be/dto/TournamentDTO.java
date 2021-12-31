package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.enumerations.TournamentType;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Tournament;

@MappedEntity(entity = Tournament.class)
public class TournamentDTO extends GenericDTO<Tournament> { 

	@JMap("tournamentType")
	private TournamentType tournamentType;
	
	@JMap("startDate")
	private Date startDate;
	
	@JMap("endDate")
	private Date endDate;	
	
	private SeasonDTO season;	

	@JMap("results")
	private List<TournamentResultsDTO> results;

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

	public TournamentType getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(TournamentType tournamentType) {
		this.tournamentType = tournamentType;
	}
	
	
	
}
