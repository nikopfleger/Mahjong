package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dao.PlayerDAO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Player;
import ar.org.mahjongriichiclub.be.service.PlayerService;

@Service("playerServiceImpl")
public class PlayerServiceImpl extends GenericServiceImpl<Player, PlayerDTO> implements PlayerService {
	
	@Autowired
	PlayerDAO playerDAO;

	@Override
	public PlayerDTO save(PlayerDTO playerDTO) throws ServiceException {

		Player player = (Player) this.convertToEntity(playerDTO);

		Player savedPlayer = this.getPlayerDAO().save(player);
		PlayerDTO savedPlayerDTO = this.convertToDto(savedPlayer);
		return savedPlayerDTO;
	}

	public PlayerDAO getPlayerDAO() {
		return playerDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}


}
