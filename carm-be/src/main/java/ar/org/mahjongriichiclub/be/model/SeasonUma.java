package ar.org.mahjongriichiclub.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;


@Entity
@Table(name="SEASON_UMA")
@SQLDelete(sql = "UPDATE SEASON_UMA SET deleted = 1 WHERE id=?")
public class SeasonUma extends Uma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074564548344207128L;
	
	@NotNull
	private Season season;

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

}
