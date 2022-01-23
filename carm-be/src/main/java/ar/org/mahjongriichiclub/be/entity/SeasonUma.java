package ar.org.mahjongriichiclub.be.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "SEASON_UMA")
@SQLDelete(sql = "UPDATE SEASON_UMA SET deleted = 1 WHERE id=?")
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
