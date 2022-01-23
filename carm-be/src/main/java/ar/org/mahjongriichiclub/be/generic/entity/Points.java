package ar.org.mahjongriichiclub.be.generic.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ar.org.mahjongriichiclub.be.entity.Player;

@MappedSuperclass
public abstract class Points extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -283687870708353098L;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Game game;

	@Column(name = "VALUE", nullable = false)
	private Integer value;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Player player;

	@Column(name = "SANMA", nullable = false)
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
