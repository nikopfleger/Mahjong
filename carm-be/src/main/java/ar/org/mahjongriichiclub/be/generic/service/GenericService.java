package ar.org.mahjongriichiclub.be.generic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;

public interface GenericService<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> {
	
	@Transactional(readOnly = false)
	ENTITY toEntity(DTO dto);
	
	@Transactional(readOnly = false)
	DTO toDTO(ENTITY entity) throws Exception;
	
	@Transactional(readOnly = false)
	List<DTO> findAll();
	
	@Transactional(readOnly = true)
	public DTO findById(Class<ENTITY> entityClass, Long id) throws Exception;

	public Class<ENTITY> findEntityClass(Class<DTO> clazz);

	public Class<DTO> findDTOClass(Class<ENTITY> clazz);




}
