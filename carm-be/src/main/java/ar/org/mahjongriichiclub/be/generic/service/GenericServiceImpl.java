package ar.org.mahjongriichiclub.be.generic.service;

import java.lang.reflect.InvocationTargetException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.dao.RepositoryDao;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ar.org.mahjongriichiclub.be.model.Person;

public abstract class GenericServiceImpl<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>>
		implements GenericService<ENTITY, DTO> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RepositoryDao<ENTITY> extendedDao;

	public DTO findById(Long id, Class<DTO> dtoClass, Class<ENTITY> entityClass) throws Exception {
		
		DTO dto = dtoClass.getDeclaredConstructor().newInstance();

		ENTITY entity = (entityClass.cast(this.extendedDao.findById(id).orElse(null)));

		if (entity != null) {
			return (DTO) this.convertToDto(entity, dto);
		}

		return null;
	}

	@Override
	public Object convertToDto(ENTITY entity, DTO dto) {
		return modelMapper.map(entity, dto.getClass());
	}

	@Override
	public Object convertToEntity(ENTITY entity, DTO dto) {
		return modelMapper.map(dto, entity.getClass());
	}

	public RepositoryDao<ENTITY> getExtendedDao() {
		return extendedDao;
	}

	public void setExtendedDao(RepositoryDao<ENTITY> extendedDao) {
		this.extendedDao = extendedDao;
	}

}
