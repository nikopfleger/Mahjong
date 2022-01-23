package ar.org.mahjongriichiclub.be.generic.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ar.org.mahjongriichiclub.be.entity.Location;
import ar.org.mahjongriichiclub.be.entity.PlayerGameResult;
import ar.org.mahjongriichiclub.be.entity.Ruleset;
import ar.org.mahjongriichiclub.be.enumerations.GameLength;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="GAME_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Game extends AbstractEntity {
	

	private static final long serialVersionUID = -6207654534713862278L;

	@Column(name="GAME_LENGTH", nullable = false)
	@Enumerated(EnumType.STRING)
	private GameLength gameLength;

	@Column(name="DATE_PLAYED", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date datePlayed;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "GAME_ID", foreignKey = @ForeignKey(name = "GAME_RESULTS_FK"))
	private List<PlayerGameResult> results;
	
	@Column(name="LOCATION")
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RULESET_ID", foreignKey = @ForeignKey(name = "GAME_RULESET_FK"), nullable = false)
	private Ruleset ruleset;


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
	
}
