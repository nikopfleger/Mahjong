package ar.org.mahjongriichiclub.be.generic.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericService<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> {

	@Transactional(readOnly = true)
	public DTO convertToDto(ENTITY entity, DTO dto);
	
	@Transactional(readOnly = true)
	public ENTITY convertToEntity(ENTITY entity,  DTO dto);
}
