package ar.org.mahjongriichiclub.be.persistence.Game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.entity.Season;
import ar.org.mahjongriichiclub.be.enumerations.GameType;
import ar.org.mahjongriichiclub.be.generic.entity.Game;

@Entity
@Table(name = "GAME")
@SQLDelete(sql = "UPDATE GAME SET deleted = 1 WHERE id=?")
@DiscriminatorValue(GameType.Values.RANKED)
public class RankedGame extends Game {

	private static final long serialVersionUID = -3825108897466638600L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEASON_ID", foreignKey = @ForeignKey(name = "GAME_SEASON_FK"))
	private Season season;

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

}
