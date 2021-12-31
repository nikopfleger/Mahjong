package ar.org.mahjongriichiclub.be.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import ar.org.mahjongriichiclub.be.enumerations.GameLength;
import ar.org.mahjongriichiclub.be.enumerations.GameType;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.Game;

public class GameDTO extends GenericDTO<Game> { 
	
	@NotNull
	private GameType gameType;
	
	@NotNull
	private GameLength gameLength;
	
	@NotNull
	private Date datePlayed;
	
	@NotNull
	private List<PlayerGameResultDTO> results;
	
	private LocationDTO location;
	
	@NotNull
	private RulesetDTO ruleset;
	
	private TournamentDTO tournament;
	
	@NotNull
	private SeasonDTO season;

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

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

	public TournamentDTO getTournament() {
		return tournament;
	}

	public void setTournament(TournamentDTO tournament) {
		this.tournament = tournament;
	}

	public SeasonDTO getSeason() {
		return season;
	}

	public void setSeason(SeasonDTO season) {
		this.season = season;
	}
	
	
}
