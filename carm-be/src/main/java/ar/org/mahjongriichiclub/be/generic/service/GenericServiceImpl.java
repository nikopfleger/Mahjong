package ar.org.mahjongriichiclub.be.generic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.mahjongriichiclub.be.annotations.MappedDTO;
import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ar.org.mahjongriichiclub.be.constants.ServiceExceptionConstants;
import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.dao.GenericDao;
import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
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
	private HashMap<Class<?>, Class<?>> entityDTORelationship;

	public D findById(Long id) throws Exception {

		E entity = this.getGenericDao().findById(id).orElse(null);

		return entity != null ? this.toDTO(entity) : null;

	}
	
	@Override
	public void save(D dto) {
		E entity = (E) this.toEntity(dto);
		try {
			entity = this.getGenericDao().save(entity);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionConstants.ERROR_SAVING_ENTITY, new String[] { dto.getClass().getSimpleName() }, e);
		}
		
		dto = this.toDTO(entity);
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

	@Override
	public Class<D> findDTOClass(Class<E> clazz) {
		return (Class<D>) this.getEntityDTORelationship().get(clazz);
	}

	@Override
	public Class<E> findEntityClass(Class<D> clazz) {
		for (Map.Entry<Class<?>, Class<?>> e : entityDTORelationship.entrySet()) {
			if (e.getValue().equals(clazz)) {
				return (Class<E>) e.getKey();
			}
		}
		return null;
	}

	@Override
	public BoundMapperFacade<E, D> findMap(Class<E> entity, Class<D> dto) {
		return (BoundMapperFacade<E, D>) mapperFactory.getMapperFacade(entity, dto, true);
	}

	@Override
	public D toDTO(E entity) {

		if (entity == null) {
			return null;
		} else if (entity instanceof HibernateProxy) {
			entity = (E) Hibernate.unproxy(entity);
		}

		Class<E> entityClass = (Class<E>) entity.getClass();
		Class<D> dtoClass = this.findDTOClass(entityClass);

		BoundMapperFacade<E, D> boundMapper = this.findMap(entityClass, dtoClass);

		return boundMapper.map(entity);
	}

	@Override
	public E toEntity(D dto) {
		
		Class<D> dtoClass = (Class<D>) dto.getClass();
		Class<E> entityClass = this.findEntityClass(dtoClass);

		BoundMapperFacade<E, D> boundMapper = this.findMap(entityClass, dtoClass);
		return boundMapper.mapReverse(dto);
	}

	public GenericDao<E> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<E> genericDao) {
		this.genericDao = genericDao;
	}

	public HashMap<Class<?>, Class<?>> getEntityDTORelationship() {
		return entityDTORelationship;
	}

	public void setEntityDTORelationship(HashMap<Class<?>, Class<?>> entityDTORelationship) {
		this.entityDTORelationship = entityDTORelationship;
	}

}
