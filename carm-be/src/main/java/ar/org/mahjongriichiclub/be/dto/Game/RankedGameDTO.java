package ar.org.mahjongriichiclub.be.dto.Game;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.dto.SeasonDTO;
import ar.org.mahjongriichiclub.be.generic.dto.GameDTO;
import ar.org.mahjongriichiclub.be.persistence.Game.RankedGame;

@MappedEntity(entity = RankedGame.class)
public class RankedGameDTO extends GameDTO {

	private SeasonDTO season;

	public SeasonDTO getSeason() {
		return season;
	}

	public void setSeason(SeasonDTO season) {
		this.season = season;
	}
}
