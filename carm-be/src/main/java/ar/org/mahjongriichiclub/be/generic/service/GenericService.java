package ar.org.mahjongriichiclub.be.generic.service;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericService<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> {

	@Transactional(readOnly = false)
	public Object convertToDto(ENTITY entity, DTO dto);
	
	@Transactional(readOnly = false)
	Object convertToEntity(ENTITY entity, DTO dto);
	
	@Transactional(readOnly = true)
	public DTO findById(Long id, Class<DTO> dtoClass, Class<ENTITY> entityClass) throws Exception;
}
