package ar.org.mahjongriichiclub.be.generic.dto;

import javax.validation.constraints.NotNull;

import ar.org.mahjongriichiclub.be.dto.GameDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;

public class PointsDTO extends GenericDTO {

	@NotNull
	private GameDTO game;
	
	@NotNull
	private Integer value;
	
	@NotNull
	private PlayerDTO player;
	
	@NotNull
	private Boolean sanma;

	public GameDTO getGame() {
		return game;
	}

	public void setGame(GameDTO game) {
		this.game = game;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public PlayerDTO getPlayer() {
		return player;
	}

	public void setPlayer(PlayerDTO player) {
		this.player = player;
	}

	public Boolean getSanma() {
		return sanma;
	}

	public void setSanma(Boolean sanma) {
		this.sanma = sanma;
	}
	
	
}
