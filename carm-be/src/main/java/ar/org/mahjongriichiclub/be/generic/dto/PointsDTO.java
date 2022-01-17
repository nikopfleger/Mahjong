package ar.org.mahjongriichiclub.be.generic.dto;

import ar.org.mahjongriichiclub.be.dto.GameDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;

public class PointsDTO extends GenericDTO {

	private GameDTO game;

	private Integer value;

	private PlayerDTO player;

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
