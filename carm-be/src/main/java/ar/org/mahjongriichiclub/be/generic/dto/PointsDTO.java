package ar.org.mahjongriichiclub.be.generic.dto;

import javax.validation.constraints.NotNull;

import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.dto.GameDTO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.generic.model.Points;

public class PointsDTO<T extends Points> extends GenericDTO<Points>  {

	@NotNull
	@JMap("game")
	private GameDTO game;
	
	@NotNull
	@JMap("value")
	private Integer value;
	
	@NotNull
	@JMap("player")
	private PlayerDTO player;
	
	@NotNull
	@JMap("sanma")
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
