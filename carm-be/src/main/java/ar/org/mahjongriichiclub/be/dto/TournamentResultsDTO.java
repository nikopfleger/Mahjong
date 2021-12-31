package ar.org.mahjongriichiclub.be.dto;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.TournamentResults;

@MappedEntity(entity = TournamentResults.class)
public class TournamentResultsDTO extends GenericDTO<TournamentResults> {

	private PlayerDTO player;
	
	@JMap("finalPlacement")
	private Integer finalPlacement;
	
	@JMap("points")
	private Integer points;

	public PlayerDTO getPlayer() {
		return player;
	}

	public void setPlayer(PlayerDTO player) {
		this.player = player;
	}

	public Integer getFinalPlacement() {
		return finalPlacement;
	}

	public void setFinalPlacement(Integer finalPlacement) {
		this.finalPlacement = finalPlacement;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
}
