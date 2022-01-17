package ar.org.mahjongriichiclub.be.dao;

import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.model.Player;

public interface PlayerDAO extends GenericDao<Player> {

	public PlayerDTO findByNickname(String nickname);

}
