package ar.org.mahjongriichiclub.be.dto;


import com.googlecode.jmapper.annotations.JMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.enumerations.Wind;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.model.PlayerGameResult;

@MappedEntity(entity = PlayerGameResult.class)
public class PlayerGameResultDTO extends GenericDTO<PlayerGameResult> {
	
	@JMap("score")
	private Integer score;
	@JMap("finalScore")
	private Integer finalScore;
	@JMap("chonbo")
	private Integer chonbo = 0;
	@JMap("startingWind")
	private Wind startingWind;
	@JMap("finalPosition")
	private Integer finalPosition;

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
	
	

}
