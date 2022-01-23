package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.entity.Player;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;

public interface PlayerDAO extends GenericDao<Player> {

	public Player findByNickname(String nickname);

}
