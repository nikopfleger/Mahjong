package ar.org.mahjongriichiclub.be.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class TournamentResultsRequest {
	
	@NotNull
	private String player;
	
	@NotNull
	private Integer finalPlacement;
	
	@NotNull
	private Integer points;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String seasonName;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	
}
