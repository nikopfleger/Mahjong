package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.entity.Uma;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public interface UmaService extends GenericService<Uma, UmaDTO> {


	@Transactional(readOnly = true)
	UmaDTO findByName(String name) throws ServiceException;


}
