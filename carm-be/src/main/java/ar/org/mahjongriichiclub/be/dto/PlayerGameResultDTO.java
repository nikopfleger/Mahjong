package ar.org.mahjongriichiclub.be.dto;


import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.entity.Player;
import ar.org.mahjongriichiclub.be.entity.PlayerGameResult;
import ar.org.mahjongriichiclub.be.enumerations.Wind;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;

@MappedEntity(entity = PlayerGameResult.class)
public class PlayerGameResultDTO extends GenericDTO {
	

	private Integer score;

	private Integer finalScore;

	private Integer chonbo = 0;

	private Wind startingWind;
	
	private Integer finalPosition;
	
	private Player player;

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
