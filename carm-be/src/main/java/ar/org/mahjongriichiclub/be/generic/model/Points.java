package ar.org.mahjongriichiclub.be.generic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ar.org.mahjongriichiclub.be.model.Game;
import ar.org.mahjongriichiclub.be.model.Player;

@MappedSuperclass
public abstract class Points extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Game game;
	
	@Column(name = "VALUE")
	private Integer value;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player player;
	
	@Column(name="SANMA")
	private Boolean sanma;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Boolean getSanma() {
		return sanma;
	}

	public void setSanma(Boolean sanma) {
		this.sanma = sanma;
	}
	
	

}
