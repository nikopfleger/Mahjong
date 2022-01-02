package ar.org.mahjongriichiclub.be.dto;


import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.TournamentResults;

@MappedEntity(entity = TournamentResults.class)
public class TournamentResultsDTO extends GenericDTO {

	private PlayerDTO player;
	
	private Integer finalPlacement;
	
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
