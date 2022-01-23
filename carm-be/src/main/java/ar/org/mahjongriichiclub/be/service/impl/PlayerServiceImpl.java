package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.dao.PlayerDAO;
import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.entity.Player;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.service.PlayerService;

@Service("playerServiceImpl")
public class PlayerServiceImpl extends GenericServiceImpl<Player, PlayerDTO> implements PlayerService {
	
	@Autowired
	PlayerDAO playerDAO;

	@Override
	public PlayerDTO findByNickname(String nickname) {
		Player player = null;
		
		try {
			
			player = this.getPlayerDAO().findByNickname(nickname);
			
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.PLAYER_DOES_NOT_EXIST, new String[] { nickname } ,e);
		}
		return this.toDTO(player);
	}
	
	@Override
	public PlayerDTO findByPersonId(Long id) {
		Player player = null;
		
		try {
			player = this.getPlayerDAO().findByPersonId(id);
			
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.PERSON_DOES_NOT_EXIST, new String[] { id.toString() } ,e);
		}
		
		return this.toDTO(player);
	}

	public PlayerDAO getPlayerDAO() {
		return playerDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}




}
