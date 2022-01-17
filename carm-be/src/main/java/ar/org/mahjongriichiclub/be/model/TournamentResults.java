package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name = "TOURNAMENT_RESULTS",  uniqueConstraints = @UniqueConstraint(columnNames={"player", "tournament", "season"}))
@SQLDelete(sql = "UPDATE TOURNAMENT_RESULTS SET deleted = 1 WHERE id=?")
public class TournamentResults extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7188440514364745299L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Player player;
	
	private Integer finalPlacement;
	
	private Integer points;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tournament tournament;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Season season;

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getFinalPlacement() {
		return finalPlacement;
	}

	public void setFinalPlacement(Integer finalPlacement) {
		this.finalPlacement = finalPlacement;
	}
	
	
}
