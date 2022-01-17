package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.PlayerDAO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Player;
import ar.org.mahjongriichiclub.be.service.PlayerService;

@Service("playerServiceImpl")
public class PlayerServiceImpl extends GenericServiceImpl<Player, PlayerDTO> implements PlayerService {
	
	@Autowired
	PlayerDAO playerDAO;

	@Override
	public PlayerDTO findByNickname(String nickname) {
		PlayerDTO player = null;
		
		try {
			
			player = this.getPlayerDAO().findByNickname(nickname);
			
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.PLAYER_DOES_NOT_EXIST, new String[] { nickname } ,e);
		}
		return player;
	}

	public PlayerDAO getPlayerDAO() {
		return playerDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}


}
