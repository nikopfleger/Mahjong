package ar.org.mahjongriichiclub.be.generic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.BiMap;

import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.entity.AbstractEntity;
import ar.org.mahjongriichiclub.be.generic.service.GenericService;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;


@Service("genericService")
public class GenericServiceImpl<E extends AbstractEntity, D extends GenericDTO>
		implements GenericService<E, D> {

	@Autowired
	private GenericDao<E> genericDao;

	@Autowired
	private MapperFactory mapperFactory;
	
	@Autowired
	private BiMap<Class<?>, Class<?>> entityDTORelationship;

	public D findById(Long id) throws Exception {

		E entity = this.getGenericDao().findById(id).orElse(null);

		return entity != null ? this.toDTO(entity) : null;

	}
	
	@Override
	public D save(D dto) {
		E entity = (E) this.toEntity(dto);
		try {
			entity = this.getGenericDao().save(entity);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.SAVING_ENTITY, new String[] { dto.getClass().getSimpleName() }, e);
		}
		
		return this.toDTO(entity);
	}

	@Override
	public List<D> findAll() {
		List<E> entityResult = this.getGenericDao().findAll();
		List<D> dtoResult = new ArrayList<>();
		for (E entity : entityResult) {
			D dtoObject = this.toDTO(entity);
			dtoResult.add(dtoObject);
		}

		return dtoResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<D> findDTOClass(Class<E> clazz) {
		return (Class<D>) this.getEntityDTORelationship().get(clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<E> findEntityClass(Class<D> clazz) {
		return (Class<E>) this.getEntityDTORelationship().inverse().get(clazz);
	}

	@Override
	public BoundMapperFacade<E, D> findMap(Class<E> entity, Class<D> dto) {
		return (BoundMapperFacade<E, D>) mapperFactory.getMapperFacade(entity, dto, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public D toDTO(E entity) {

		if (entity == null) {
			return null;
		} else if (entity instanceof HibernateProxy) {
			entity = this.unproxy(entity);
		}

		Class<E> entityClass = (Class<E>) entity.getClass();
		Class<D> dtoClass = this.findDTOClass(entityClass);

		BoundMapperFacade<E, D> boundMapper = this.findMap(entityClass, dtoClass);

		return boundMapper.map(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E toEntity(D dto) {
		
		Class<D> dtoClass = (Class<D>) dto.getClass();
		Class<E> entityClass = this.findEntityClass(dtoClass);

		BoundMapperFacade<E, D> boundMapper = this.findMap(entityClass, dtoClass);
		return boundMapper.mapReverse(dto);
	}

	@SuppressWarnings("unchecked")
	public E unproxy(E proxied)
	{
	    E entity = proxied;
	    if (entity instanceof HibernateProxy) {
	        Hibernate.initialize(entity);
	        entity = (E) ((HibernateProxy) entity)
	                  .getHibernateLazyInitializer()
	                  .getImplementation();
	    }
	    return entity;
	}

	public GenericDao<E> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<E> genericDao) {
		this.genericDao = genericDao;
	}

	public BiMap<Class<?>, Class<?>> getEntityDTORelationship() {
		return entityDTORelationship;
	}

	public void setEntityDTORelationship(BiMap<Class<?>, Class<?>> entityDTORelationship) {
		this.entityDTORelationship = entityDTORelationship;
	}

}
