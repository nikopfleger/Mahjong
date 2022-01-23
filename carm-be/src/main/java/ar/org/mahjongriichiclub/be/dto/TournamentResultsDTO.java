package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.entity.Tournament;
import ar.org.mahjongriichiclub.be.entity.TournamentResults;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

@MappedEntity(entity = TournamentResults.class)
public class TournamentResultsDTO extends GenericDTO {

	private PlayerDTO player;

	private Integer finalPlacement;

	private Integer points;

	private Tournament tournament;

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

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
