package ar.org.mahjongriichiclub.be.dto.Game;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.dto.TournamentDTO;
import ar.org.mahjongriichiclub.be.persistence.Game.TournamentGame;

@MappedEntity(entity = TournamentGame.class)
public class TournamentGameDTO extends RankedGameDTO {

	private TournamentDTO tournament;

	public TournamentDTO getTournament() {
		return tournament;
	}

	public void setTournament(TournamentDTO tournament) {
		this.tournament = tournament;
	}

}
