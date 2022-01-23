package ar.org.mahjongriichiclub.be.dto;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.entity.SeasonUma;

@MappedEntity(entity = SeasonUma.class)
public class SeasonUmaDTO extends UmaDTO {
	
	private SeasonDTO season;

	public SeasonDTO getSeason() {
		return season;
	}

	public void setSeason(SeasonDTO season) {
		this.season = season;
	}

}
