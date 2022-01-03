package ar.org.mahjongriichiclub.be.service.impl;

import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.dto.PlayerDTO;
import ar.org.mahjongriichiclub.be.generic.service.impl.GenericServiceImpl;
import ar.org.mahjongriichiclub.be.model.Player;
import ar.org.mahjongriichiclub.be.service.PlayerService;

@Service("playerServiceImpl")
public class PlayerServiceImpl extends GenericServiceImpl<Player, PlayerDTO> implements PlayerService {


}
