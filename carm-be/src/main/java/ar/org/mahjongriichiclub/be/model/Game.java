package ar.org.mahjongriichiclub.be.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.GameLength;
import ar.org.mahjongriichiclub.be.enumerations.GameType;
import ar.org.mahjongriichiclub.be.enumerations.TournamentType;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name = "GAME")
@SQLDelete(sql = "UPDATE GAME SET deleted = 1 WHERE id=?")
public class Game extends AbstractEntity {
	
	@Column(name="GAME_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private GameType gameType;
	
	@Column(name="GAME_LENGTH", nullable = false)
	@Enumerated(EnumType.STRING)
	private GameLength gameLength;

	@Column(name="DATE_PLAYED", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date datePlayed;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "GAME_ID", foreignKey = @ForeignKey(name = "GAME_RESULTS_FK"))
	private List<PlayerGameResult> results;
	
	@Column(name="LOCATION")
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RULESET_ID", foreignKey = @ForeignKey(name = "GAME_RULESET_FK"))
	private Ruleset ruleset;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TOURNAMENT_ID", foreignKey = @ForeignKey(name = "GAME_TOURNAMENT_FK"))
	@Enumerated(EnumType.STRING)
	private Tournament tournament;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "SEASON_ID", foreignKey = @ForeignKey(name = "GAME_SEASON_FK"))
	private Season season;

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

	public List<PlayerGameResult> getResults() {
		return results;
	}

	public void setResults(List<PlayerGameResult> results) {
		this.results = results;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Ruleset getRuleset() {
		return ruleset;
	}

	public void setRuleset(Ruleset ruleset) {
		this.ruleset = ruleset;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	
	
	
	
}
