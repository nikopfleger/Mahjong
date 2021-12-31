package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.TournamentResultsDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

@Entity
@Table(name = "TOURNAMENT_RESULTS")
@SQLDelete(sql = "UPDATE TOURNAMENT_RESULTS SET deleted = 1 WHERE id=?")
@MappedDTO(dto = TournamentResultsDTO.class)
public class TournamentResults extends AbstractEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7188440514364745299L;

	private Player player;
	
	private Integer finalPlacement;
	
	private Integer points;

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
