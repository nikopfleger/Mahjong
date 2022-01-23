package ar.org.mahjongriichiclub.be.dto.Game;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.generic.dto.GameDTO;
import ar.org.mahjongriichiclub.be.persistence.Game.CasualGame;

@MappedEntity(entity = CasualGame.class)
public class CasualGameDTO extends GameDTO {

}
