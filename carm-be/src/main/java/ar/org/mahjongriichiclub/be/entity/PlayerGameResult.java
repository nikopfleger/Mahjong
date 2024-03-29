package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.Wind;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;
import ar.org.mahjongriichiclub.be.generic.entity.Game;

@Entity
@Table(name = "PLAYER_GAME_RESULT")
@SQLDelete(sql = "UPDATE PLAYER_GAME_RESULT SET deleted = 1 WHERE id=?")
public class PlayerGameResult extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332843877588114705L;
	private static final long PRIMERA_POSICION = 1L;
	private static final long ULTIMA_POSICION = 4L;

	@Column(name = "SCORE")
	private Integer score;

	@Column(name = "FINAL_SCORE", nullable = false)
	private Integer finalScore;

	@Column(name = "CHONBO")
	private Integer chonbo;

	@Column(name = "STARTING_WIND")
	private Wind startingWind;

	@Column(name = "FINAL_POSITION")
	@Min(PRIMERA_POSICION)
	@Max(ULTIMA_POSICION)
	private Integer finalPosition;

	@ManyToOne(fetch = FetchType.LAZY)
	private Player player;

	@ManyToOne(fetch = FetchType.LAZY)
	private Game game;

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Integer finalScore) {
		this.finalScore = finalScore;
	}

	public Integer getChonbo() {
		return chonbo;
	}

	public void setChonbo(Integer chonbo) {
		this.chonbo = chonbo;
	}

	public Wind getStartingWind() {
		return startingWind;
	}

	public void setStartingWind(Wind startingWind) {
		this.startingWind = startingWind;
	}

	public Integer getFinalPosition() {
		return finalPosition;
	}

	public void setFinalPosition(Integer finalPosition) {
		this.finalPosition = finalPosition;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
