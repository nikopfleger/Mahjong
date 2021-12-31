package ar.org.mahjongriichiclub.be.generic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericService<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> {
	
	@Transactional(readOnly = false)
	ENTITY convertToEntity(DTO dto);
	
	@Transactional(readOnly = false)
	DTO convertToDto(ENTITY entity) throws Exception;
	
	@Transactional(readOnly = false)
	List<DTO> findAll();
	
	@Transactional(readOnly = true)
	public DTO findById(Class<ENTITY> entityClass, Long id) throws Exception;

	public Class<?> findDTOClass(Class<? extends AbstractEntity> clazz);

	public Class<?> findEntityClass(Class<DTO> clazz);




}
