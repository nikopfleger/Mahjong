package ar.org.mahjongriichiclub.be.persistence.Game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.entity.Tournament;
import ar.org.mahjongriichiclub.be.enumerations.GameType;

@Entity
@Table(name = "GAME")
@SQLDelete(sql = "UPDATE GAME SET deleted = 1 WHERE id=?")
@DiscriminatorValue(GameType.Values.TOURNAMENT)
public class TournamentGame extends RankedGame {

	private static final long serialVersionUID = -564702749948540571L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", foreignKey = @ForeignKey(name = "GAME_TOURNAMENT_FK"))
	@Enumerated(EnumType.STRING)
	private Tournament tournament;

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
