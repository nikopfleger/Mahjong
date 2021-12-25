package ar.org.mahjongriichiclub.be.generic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ar.org.mahjongriichiclub.be.model.Person;

public class GenericServiceImpl<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>> implements GenericService<ENTITY, DTO> {
	
    @Autowired
    private ModelMapper modelMapper;

	@Override
	public Object convertToDto(ENTITY entity, DTO dto) {
		return modelMapper.map(entity, dto.getClass());
	}

	@Override
	public Object convertToEntity(ENTITY entity, DTO dto) {
		return modelMapper.map(dto, entity.getClass());
	}

}
