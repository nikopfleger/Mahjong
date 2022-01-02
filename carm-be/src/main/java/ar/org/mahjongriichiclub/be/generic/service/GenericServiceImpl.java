package ar.org.mahjongriichiclub.be.generic.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;


@Service("genericService")
public class GenericServiceImpl<ENTITY extends AbstractEntity, DTO extends GenericDTO>
		implements GenericService<ENTITY, DTO> {

	@Autowired
	private GenericDao<ENTITY> genericDao;

	@Autowired
	private MapperFactory mapperFactory;

	public DTO findById(Class<ENTITY> entityClass, Long id) throws Exception {

		ENTITY entity = this.getGenericDao().findById(id).orElse(null);

		return entity != null ? this.toDTO(entity) : null;

	}
	
	@Override
	public void save(DTO dto) {
		ENTITY entity = (ENTITY) this.toEntity(dto);
		try {
			entity = this.getGenericDao().save(entity);
		} catch (Exception e) {
			throw new ServiceException("Error persistiendo entidad " + dto.getClass().getSimpleName());
		}
		
		dto = this.toDTO(entity);
	}

	@Override
	public List<DTO> findAll() {
		List<ENTITY> entityResult = this.getGenericDao().findAll();
		List<DTO> dtoResult = new ArrayList<>();
		for (ENTITY entity : entityResult) {
			DTO dtoObject = this.toDTO(entity);
			dtoResult.add(dtoObject);
		}

		return dtoResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<DTO> findDTOClass(Class<ENTITY> clazz) {
		return clazz.getAnnotation(MappedDTO.class).dto();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<ENTITY> findEntityClass(Class<DTO> clazz) {
		return clazz.getAnnotation(MappedEntity.class).entity();
	}

	@SuppressWarnings("unchecked")
	public BoundMapperFacade<ENTITY, DTO> findOrCreateMap(Class<?> entity, Class<?> dto) {
		return (BoundMapperFacade<ENTITY, DTO>) mapperFactory.getMapperFacade(entity, dto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DTO toDTO(ENTITY entity) {

		if (entity == null) {
			return null;
		} else if (entity instanceof HibernateProxy) {
			entity = (ENTITY) Hibernate.unproxy(entity);
		}

		Class<ENTITY> entityClass = (Class<ENTITY>) entity.getClass();
		Class<DTO> dtoClass = this.findDTOClass(entityClass);

		BoundMapperFacade<ENTITY, DTO> boundMapper = this.findOrCreateMap(entityClass, dtoClass);

		return boundMapper.map(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ENTITY toEntity(DTO dto) {
		
		Class<DTO> dtoClass = (Class<DTO>) dto.getClass();
		Class<ENTITY> entityClass = this.findEntityClass(dtoClass);

		BoundMapperFacade<ENTITY, DTO> boundMapper = this.findOrCreateMap(entityClass, dtoClass);
		return boundMapper.mapReverse(dto);
	}

	public GenericDao<ENTITY> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<ENTITY> genericDao) {
		this.genericDao = genericDao;
	}

}
