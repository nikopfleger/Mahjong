package ar.org.mahjongriichiclub.be.generic.dto;

import java.util.Date;
import java.util.List;

import ar.org.mahjongriichiclub.be.dto.LocationDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerGameResultDTO;
import ar.org.mahjongriichiclub.be.dto.RulesetDTO;
import ar.org.mahjongriichiclub.be.enumerations.GameLength;

public abstract class GameDTO extends GenericDTO { 
	
	private GameLength gameLength;
	
	private Date datePlayed;
	
	private List<PlayerGameResultDTO> results;
	
	private LocationDTO location;
	
	private RulesetDTO ruleset;

	public GameLength getGameLength() {
		return gameLength;
	}

	public void setGameLength(GameLength gameLength) {
		this.gameLength = gameLength;
	}

	public Date getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
		this.datePlayed = datePlayed;
	}

	public List<PlayerGameResultDTO> getResults() {
		return results;
	}

	public void setResults(List<PlayerGameResultDTO> results) {
		this.results = results;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public RulesetDTO getRuleset() {
		return ruleset;
	}

	public void setRuleset(RulesetDTO ruleset) {
		this.ruleset = ruleset;
	}
	
	
}
