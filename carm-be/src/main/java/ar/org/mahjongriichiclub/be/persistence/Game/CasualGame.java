package ar.org.mahjongriichiclub.be.persistence.Game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import ar.org.mahjongriichiclub.be.enumerations.GameType;
import ar.org.mahjongriichiclub.be.generic.entity.Game;

@Entity
@Table(name = "GAME")
@SQLDelete(sql = "UPDATE GAME SET deleted = 1 WHERE id=?")
@DiscriminatorValue(GameType.Values.CASUAL)
public class CasualGame extends Game {

	private static final long serialVersionUID = -3825108897466638600L;

}
