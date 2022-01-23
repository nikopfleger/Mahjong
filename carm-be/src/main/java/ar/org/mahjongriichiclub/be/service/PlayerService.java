package ar.org.mahjongriichiclub.be.service;



import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.entity.Player;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface PlayerService extends GenericService<Player,PlayerDTO> {

	@Transactional(readOnly = true)
	public PlayerDTO findByNickname(String nickname);

	@Transactional(readOnly = true)
	public PlayerDTO findByPersonId(Long id);
}
