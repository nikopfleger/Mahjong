package ar.org.mahjongriichiclub.be.generic.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.dto.PersonDTO;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ar.org.mahjongriichiclub.be.model.Person;

@Service("genericService")
public class GenericServiceImpl<ENTITY extends AbstractEntity, DTO extends GenericDTO<ENTITY>>
		implements GenericService<ENTITY, DTO> {


	@Autowired
	private GenericDao<ENTITY> genericDao;

	public DTO findById(Class<ENTITY> entityClass, Long id) throws Exception {

		DTO dto = (DTO) this.findDTOClass(entityClass).getDeclaredConstructor().newInstance();

		ENTITY entity = this.getGenericDao().findById(id).orElse(null);

		return entity != null ? this.convertToDto(entity) : null;

	}

	@Override
	public List<DTO> findAll() {
		List<ENTITY> entityResult = this.getGenericDao().findAll();
		List<DTO> dtoResult = new ArrayList<>();
		for (ENTITY entity : entityResult) {
			DTO dtoObject = this.convertToDto(entity);
			dtoResult.add(dtoObject);
		}

		return dtoResult;
	}

	@Override
	public Class<?> findDTOClass(Class<? extends AbstractEntity> clazz) {
		return clazz.getAnnotation(MappedDTO.class).dto();
	}
	
	@Override
	public Class<?> findEntityClass(Class<DTO> clazz) {
		return clazz.getAnnotation(MappedEntity.class).entity();
	}


	@Override
	public DTO convertToDto(ENTITY entity) {

		if (entity == null) {
			return null;
		} else if (entity instanceof HibernateProxy) {
			entity = (ENTITY) Hibernate.unproxy(entity);
		}

		Class<?> dtoClass = this.findDTOClass(entity.getClass());
		Class<?> entityClass = entity.getClass();

		DTO dto = null;
		try {
			dto = (DTO) dtoClass.getDeclaredConstructor().newInstance();
			JMapper<DTO, ENTITY> entityMapper = (JMapper<DTO,ENTITY>) new JMapper(dtoClass, entityClass);

			dto = entityMapper.getDestination(entity);
			// dto = (DTO) modelMapper.map(entity, dto.getClass());
		} catch (Exception e) {
			throw new ServiceException("Error al instanciar el DTO");
		}

		return dto;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ENTITY convertToEntity(DTO dto) {
		Class<DTO> dtoClass = (Class<DTO>) dto.getClass();
		Class<ENTITY> entityClass = (Class<ENTITY>) this.findEntityClass(dtoClass);
		JMapper<ENTITY, DTO> dtoMapper = (JMapper<ENTITY,DTO>) new JMapper(entityClass, dtoClass);
//		return modelMapper.map(dto, dto.getType());
		return dtoMapper.getDestinationWithoutControl(dto);
	}

	public GenericDao<ENTITY> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<ENTITY> genericDao) {
		this.genericDao = genericDao;
	}


}
