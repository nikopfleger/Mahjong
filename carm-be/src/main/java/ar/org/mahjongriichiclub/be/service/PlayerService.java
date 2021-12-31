package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Player;

public interface PlayerService extends GenericService<Player,PlayerDTO> {

	@Transactional(readOnly = false)
	public PlayerDTO save(PlayerDTO playerDTO);
}
