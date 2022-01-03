package ar.org.mahjongriichiclub.be.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.dto.UmaDTO;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ar.org.mahjongriichiclub.be.model.Uma;

public interface UmaService extends GenericService<Uma, UmaDTO> {

	@Transactional(readOnly = true)
	public UmaDTO findOneByIdAndName(Long id, String name);

	@Transactional(readOnly = true)
	UmaDTO findByName(String name);

}
