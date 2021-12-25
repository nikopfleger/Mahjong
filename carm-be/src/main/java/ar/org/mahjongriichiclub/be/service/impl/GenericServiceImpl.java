package ar.org.mahjongriichiclub.be.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;

public class GenericServiceImpl<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> implements GenericService<ENTITY, DTO> {
	
    @Autowired
    private ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	@Override
	public DTO convertToDto(ENTITY entity, DTO dto) {
		return (DTO) modelMapper.map(entity, dto.getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ENTITY convertToEntity(ENTITY entity, DTO dto) {
		return (ENTITY) modelMapper.map(dto, entity.getClass());
	}

}
