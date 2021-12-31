package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.dto.SeasonUmaDTO;

@Entity
@Table(name="SEASON_UMA")
@SQLDelete(sql = "UPDATE SEASON_UMA SET deleted = 1 WHERE id=?")
@MappedDTO(dto = SeasonUmaDTO.class)
public class SeasonUma extends Uma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074564548344207128L;
	
	private Season season;

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

}
