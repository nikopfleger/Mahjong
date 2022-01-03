package ar.org.mahjongriichiclub.be.generic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.org.mahjongriichiclub.be.generic.dto.GenericDTO;
import ar.org.mahjongriichiclub.be.generic.model.AbstractEntity;
import ma.glasnost.orika.BoundMapperFacade;

public interface GenericService<E extends AbstractEntity, D extends GenericDTO> {
	
	@Transactional(readOnly = false)
	E toEntity(D dto);
	
	@Transactional(readOnly = false)
	D toDTO(E entity) throws Exception;
	
	@Transactional(readOnly = false)
	List<D> findAll();
	
	@Transactional(readOnly = true)
	public D findById(Long id) throws Exception;	

	@Transactional(readOnly = false)
	public D save(D dto);
	
	public Class<E> findEntityClass(Class<D> clazz);

	public Class<D> findDTOClass(Class<E> clazz);

	public BoundMapperFacade<E, D> findMap(Class<E> entity, Class<D> dto);

	






}
